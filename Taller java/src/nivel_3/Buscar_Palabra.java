package nivel_3;

public class Buscar_Palabra {
    public static boolean buscar_palabra(String cadena, String palabra) {
        return cadena.contains(palabra);
    }
    public static void main(String[] args) {
        System.out.println(buscar_palabra("hola mundo", "mundo"));
    }
}
