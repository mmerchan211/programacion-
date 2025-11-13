// Juego.java
// IDEAS: Controla la simulación completa. Se encarga de:
// 1. Inicializar el mapa, el explorador y el tesoro.
// 2. Ejecutar el algoritmo de búsqueda paso a paso.
// 3. Mostrar el estado del mapa en consola y guardar el resultado en archivo.
// 4. Terminar cuando el explorador encuentra el tesoro.

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego {
    private final Mapa mapa;
    private final Explorador explorador;
    private final Tesoro tesoro;
    private final List<String> logLines = new ArrayList<>();

    public Juego(Mapa mapa, Explorador explorador, Tesoro tesoro) {
        this.mapa = mapa;
        this.explorador = explorador;
        this.tesoro = tesoro;
        // marcar la posición inicial como visitada
        mapa.marcarVisitado(explorador.getX(), explorador.getY());
    }

    // Calcula distancia Manhattan (útil para dirigir el movimiento)
    private int distanciaManhattan(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    // Registra mensaje en consola y en buffer para archivo
    private void registrar(String s) {
        System.out.println(s);
        logLines.add(s);
    }

    // Imprime el mapa con E para explorador, T para tesoro, . visitado, - no visitado
    private void mostrarMapa() {
        StringBuilder sb = new StringBuilder();
        int f = mapa.getFilas();
        int c = mapa.getColumnas();
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                if (i == explorador.getX() && j == explorador.getY()) sb.append("E ");
                else if (i == tesoro.getX() && j == tesoro.getY()) sb.append("T ");
                else if (mapa.fueVisitado(i, j)) sb.append(". ");
                else sb.append("- ");
            }
            sb.append('\n');
        }
        registrar(sb.toString());
    }

    // Algoritmo de búsqueda greedy con fallback (explicado en el documento)
    public void iniciarBusqueda() {
        registrar("Mapa inicial:");
        mostrarMapa();

        while (!(explorador.getX() == tesoro.getX() && explorador.getY() == tesoro.getY())) {
            int ex = explorador.getX();
            int ey = explorador.getY();
            int tx = tesoro.getX();
            int ty = tesoro.getY();

            // dirección preferente en x e y: -1, 0 o 1
            int dx = Integer.compare(tx, ex);
            int dy = Integer.compare(ty, ey);

            // candidatos ordenados por preferencia (primero direcciones que acercan)
            int[][] candidatos = {
                {ex + dx, ey},     // mover en X hacia el tesoro
                {ex, ey + dy},     // mover en Y hacia el tesoro
                {ex - dx, ey},     // alternativa inversa en X
                {ex, ey - dy},     // alternativa inversa en Y
                {ex + 1, ey},
                {ex - 1, ey},
                {ex, ey + 1},
                {ex, ey - 1}
            };

            boolean movido = false;
            // preferimos celdas válidas y no visitadas
            for (int[] pos : candidatos) {
                int nx = pos[0], ny = pos[1];
                if (!mapa.posicionValida(nx, ny)) continue;
                if (mapa.fueVisitado(nx, ny)) continue;
                explorador.moverA(nx, ny);
                mapa.marcarVisitado(nx, ny);
                registrar("Movimiento a: (" + nx + "," + ny + ") - pasos: " + explorador.getPasos() + " - distancia restante: " + distanciaManhattan(nx, ny, tx, ty));
                mostrarMapa();
                movido = true;
                break;
            }

            // fallback: si no encontramos celdas nuevas, permitir moverse a una visitada válida
            if (!movido) {
                boolean movedFallback = false;
                for (int[] pos : candidatos) {
                    int nx = pos[0], ny = pos[1];
                    if (!mapa.posicionValida(nx, ny)) continue;
                    // aquí aceptamos incluso si fueVisitado == true
                    explorador.moverA(nx, ny);
                    mapa.marcarVisitado(nx, ny);
                    registrar("(Fallback) Movimiento a: (" + nx + "," + ny + ") - pasos: " + explorador.getPasos()  + " - distancia restante: " + distanciaManhattan(nx, ny, tx, ty));
                    mostrarMapa();
                    movedFallback = true;
                    break;
                }
                if (!movedFallback) {
                    registrar("No se encontraron movimientos válidos. Terminando búsqueda.");
                    break;
                }
            }
        }

        if (explorador.getX() == tesoro.getX() && explorador.getY() == tesoro.getY()) {
            registrar("\n¡Tesoro encontrado en " + explorador.getPasos() + " pasos! Posición: (" + explorador.getX() + "," + explorador.getY() + ")");
        }

        escribirRegistroAArchivo("resultado_explorador.txt");
    }

    // Escribe el log en un archivo de texto
    private void escribirRegistroAArchivo(String nombreArchivo) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String linea : logLines) {
                bw.write(linea);
                bw.newLine();
            }
            registrar("\nRegistro escrito en: " + nombreArchivo);
        } catch (IOException e) {
            registrar("Error al escribir el archivo: " + e.getMessage());
        }
    }

    // Método de conveniencia para crear un Juego con posiciones aleatorias
    public static Juego crearAleatorio(int filas, int columnas) {
        Random rnd = new Random();
        int ex = rnd.nextInt(filas);
        int ey = rnd.nextInt(columnas);
        int tx, ty;
        do {
            tx = rnd.nextInt(filas);
            ty = rnd.nextInt(columnas);
        } while (tx == ex && ty == ey);
        Mapa mapa = new Mapa(filas, columnas);
        Explorador explorador = new Explorador(ex, ey);
        Tesoro tesoro = new Tesoro(tx, ty);
        return new Juego(mapa, explorador, tesoro);
    }
}

