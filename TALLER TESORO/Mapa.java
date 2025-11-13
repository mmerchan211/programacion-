// Mapa.java
// IDEAS: Representa el terreno del juego como una cuadrícula de celdas.
// Se encarga de validar los límites del mapa y registrar las posiciones visitadas.
// Cada celda puede estar vacía, visitada o contener al explorador o al tesoro.

import java.util.Arrays;

public class Mapa {
    private final int filas;
    private final int columnas;
    private final boolean[][] visitado;

    public Mapa(int filas, int columnas) {
        if (filas <= 0 || columnas <= 0) throw new IllegalArgumentException("Filas y columnas deben ser mayores que 0.");
        this.filas = filas;
        this.columnas = columnas;
        this.visitado = new boolean[filas][columnas];
        for (boolean[] row : visitado) Arrays.fill(row, false);
    }

    // Valida que la posición esté dentro de los límites del mapa
    public boolean posicionValida(int x, int y) {
        return x >= 0 && x < filas && y >= 0 && y < columnas;
    }

    // Marca una celda como visitada (para evitar repeticiones)
    public void marcarVisitado(int x, int y) {
        if (posicionValida(x, y)) visitado[x][y] = true;
    }

    // Consulta si una celda fue visitada
    public boolean fueVisitado(int x, int y) {
        if (!posicionValida(x, y)) return false;
        return visitado[x][y];
    }

    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }
}
