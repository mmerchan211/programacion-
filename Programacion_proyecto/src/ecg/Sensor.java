package ecg;

import java.sql.Connection;
import java.util.*;

public class Sensor {

    private List<ECGRecord> databaseRecords;
    private Random rnd = new Random();

    /**
     * Constructor por defecto: intenta cargar registros desde CSV en resources/data/ecg_database.csv
     * Si no existe, la lista quedará vacía.
     */
    public Sensor() {
        try {
            databaseRecords = CSVDatabase.loadFromCSV("resources/data/ecg_database.csv");
        } catch (Exception e) {
            System.err.println("No se pudo cargar CSV: " + e.getMessage());
            databaseRecords = new ArrayList<>();
        }
    }

    /**
     * Constructor alternativo: carga registros desde una conexión SQLite (u otra DB compatible)
     */
    public Sensor(Connection conn) {
        try {
            databaseRecords = DBReader.getAllRecords(conn);
        } catch (Exception e) {
            System.err.println("Error leyendo DB: " + e.getMessage());
            databaseRecords = new ArrayList<>();
        }
    }

    // Simula lectura en vivo: devuelve un vector de muestras (esto NO es simulación de la base de datos)
    public double[] readLiveSignal(int samples) {
        double[] s = new double[samples];
        for (int i = 0; i < samples; i++) {
            double t = i / 50.0;
            double base = Math.sin(t * Math.PI * 2) * 0.25;
            if (rnd.nextDouble() < 0.015) base += 0.85; // picos esporádicos
            s[i] = Math.max(-1, Math.min(1, base + rnd.nextGaussian() * 0.06));
        }
        return s;
    }

    // Obtiene un registro histórico (aleatorio) de la fuente cargada (CSV o DB)
    public ECGRecord getHistoricalRecord() {
        if (databaseRecords == null || databaseRecords.isEmpty()) return null;
        int idx = rnd.nextInt(databaseRecords.size());
        return databaseRecords.get(idx);
    }

    // Obtener todos los registros cargados
    public List<ECGRecord> getAllRecords() {
        return Collections.unmodifiableList(databaseRecords);
    }
}
