package nivel_3;

public class Invertir_cadena {
    public static String invertir_cadena(String cadena) {
        return new StringBuilder(cadena).reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(invertir_cadena("Hola, ¿Comó estas?"));
    }
}
