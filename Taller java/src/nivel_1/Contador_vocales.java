package nivel_1;

import java.util.Scanner;

public class Contador_vocales {
    public static int contador_vocales() {
        try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Ingrese una cadena: ");
			String s = sc.nextLine();
			String vocales = "aeiouáéíóúAEIOUÁÉÍÓÚ";
			int contador = 0;
			for (int i = 0; i < s.length(); i++) {
			    if (vocales.indexOf(s.charAt(i)) != -1) {
			        contador++;
			    }
			}
			System.out.println("Número de vocales: " + contador);
			return contador;
		}
    }

    public static void main(String[] args) {
        contador_vocales();
    }
}
