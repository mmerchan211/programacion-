package nivel_4;

public class Contar_ocurrencias {
    public static int contar_ocurrencias(String cadena, String palabra) {
        cadena = cadena.toLowerCase();
        palabra = palabra.toLowerCase();

        String[] palabras = cadena.split("\\s+");
        int contador = 0;

        for (String p : palabras) {
            if (p.equals(palabra)) {
                contador++;
            }
        }

        // Mostrar mensaje en consola
        if (contador == 1) {
            System.out.println("La palabra \"" + palabra + "\" se repite " + contador + " vez.");
        } else {
            System.out.println("La palabra \"" + palabra + "\" se repite " + contador + " veces.");
        }

        return contador;
    }

    // Método principal para probar el código
    public static void main(String[] args) {
        String texto = "A maira le gusta mucho el mes de abril, porque en abril maira cumple años,";
        contar_ocurrencias(texto, "abril");
    }
}
