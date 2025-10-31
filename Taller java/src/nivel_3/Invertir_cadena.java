package nivel_3;

import java.util.Scanner;

public class Invertir_Cadena {
    public static String invertirCadena(String cadena) {
        return new StringBuilder(cadena).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(" Ingresa una cadena para invertir: ");
        String entrada = sc.nextLine();
        String resultado = invertirCadena(entrada);
        System.out.println("Cadena invertida: " + resultado);
        sc.close();
    }
}
