// Tesoro.java
// IDEAS: Representa el objetivo del explorador dentro del mapa.
// Tiene una posición fija (x,y) donde se encuentra oculto el tesoro.
// No cambia durante la ejecución del juego.

public class Tesoro {
    private final int x;
    private final int y;

    public Tesoro(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}
