// Main.java
// Clase principal separada que crea una instancia de Juego y la ejecuta.
// Aquí puedes cambiar tamaño del mapa o posiciones iniciales manualmente.

public class Main {
    public static void main(String[] args) {
        // Opción A: crear aleatoriamente (cambiar filas/columnas si se desea)
        Juego juego = Juego.crearAleatorio(6, 8);
        juego.iniciarBusqueda();
    }
}
