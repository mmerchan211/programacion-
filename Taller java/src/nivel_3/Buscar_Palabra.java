package nivel_3;

import java.util.Scanner;

public class Buscar_Palabra {
    static boolean buscarPalabra(String cadena, String palabra) {
        return cadena.toLowerCase().contains(palabra.toLowerCase());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa una cadena de texto: ");
        String texto = sc.nextLine();

        System.out.print("Ingresa la palabra que deseas buscar: ");
        String palabra = sc.nextLine();

        // Llamada a la función
        boolean encontrada = buscarPalabra(texto, palabra);

        // Resultado
        if (encontrada) {
            System.out.println("La palabra \"" + palabra + "\" se encuentra en la cadena.");
        } else {
            System.out.println("La palabra \"" + palabra + "\" NO se encuentra en la cadena.");
        }

        sc.close();
    }
}

