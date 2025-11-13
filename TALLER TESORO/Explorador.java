// Explorador.java
// IDEAS: Representa al personaje principal del juego.
// Puede moverse dentro del mapa en cuatro direcciones.
// Lleva la cuenta de los pasos realizados y su posición actual.

public class Explorador {
    private int x;
    private int y;
    private int pasos;

    public Explorador(int x, int y) {
        this.x = x;
        this.y = y;
        this.pasos = 0;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getPasos() { return pasos; }

    // Mueve al explorador a una nueva posición y aumenta el contador de pasos
    public void moverA(int nuevoX, int nuevoY) {
        this.x = nuevoX;
        this.y = nuevoY;
        this.pasos++;
    }
}

