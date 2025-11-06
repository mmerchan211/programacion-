package ecg;

import javax.swing.*;
import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) throws Exception {
        Sensor sensor = new Sensor(); // intenta leer CSV por defecto

        while (true) {
            String[] options = {"Simular lectura en vivo", "Leer registro histórico (CSV)", "Leer desde BD SQLite", "Salir"};
            String choice = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione una acción",
                    "Monitor ECG - Menú",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (choice == null || choice.equals("Salir")) {
                JOptionPane.showMessageDialog(null, "Saliendo del monitor. ¡Hasta luego!");
                System.exit(0);
            } else if (choice.equals("Simular lectura en vivo")) {
                double[] live = sensor.readLiveSignal(800);
                String info = String.format("Lectura en vivo\nMuestras: %d\nPromedio(abs): %.3f",
                        live.length, Arrays.stream(live).map(Math::abs).average().orElse(0.0));
                Pantalla.showSignal(live, "ECG - Lectura en vivo", info);
            } else if (choice.equals("Leer registro histórico (CSV)")) {
                List<ECGRecord> all = sensor.getAllRecords();
                if (all == null || all.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se encontraron registros CSV en resources/data/ecg_database.csv");
                    continue;
                }
                String sel = Pantalla.chooseRecordDialog(all);
                if (sel == null) continue;
                String id = sel.split(" — ")[0].trim();
                ECGRecord rec = all.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
                if (rec != null) {
                    Pantalla.showSignal(rec.getSignal(), "Registro: " + rec.getId(), rec.getDescription() + "<br>" + rec.getTimestamp());
                } else {
                    JOptionPane.showMessageDialog(null, "Registro no encontrado.");
                }
            } else if (choice.equals("Leer desde BD SQLite")) {
                String dbPath = JOptionPane.showInputDialog(null, "Ruta a la BD SQLite (ej: resources/data/ecg.db):", "resources/data/ecg.db");
                if (dbPath == null || dbPath.trim().isEmpty()) continue;
                try (Connection conn = DatabaseUtils.connectSQLite(dbPath)) {
                    DatabaseUtils.createTableIfNotExists(conn);
                    Sensor sensorDb = new Sensor(conn);
                    List<ECGRecord> recs = sensorDb.getAllRecords();
                    if (recs == null || recs.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay registros en la BD (tabla ecg_records vacía).");
                    } else {
                        String sel = Pantalla.chooseRecordDialog(recs);
                        if (sel == null) continue;
                        String id = sel.split(" — ")[0].trim();
                        ECGRecord rec = recs.stream().filter(r -> r.getId().equals(id)).findFirst().orElse(null);
                        if (rec != null) {
                            Pantalla.showSignal(rec.getSignal(), "Registro BD: " + rec.getId(), rec.getDescription() + "<br>" + rec.getTimestamp());
                        } else {
                            JOptionPane.showMessageDialog(null, "Registro no encontrado en BD.");
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al conectar la BD: " + ex.getMessage());
                }
            }
        }
    }
}