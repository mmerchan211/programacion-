package nivel_1;

import java.util.Scanner;

public class Suma {
    public static void suma() {
        try (Scanner sc = new Scanner(System.in)) {
			try {
			    System.out.print("Ingrese el primer número: ");
			    double a = Double.parseDouble(sc.nextLine());
			    System.out.print("Ingrese el segundo número: ");
			    double b = Double.parseDouble(sc.nextLine());
			    System.out.println("La suma es: " + (a + b));
			} catch (NumberFormatException e) {
			    System.out.println("Por favor ingrese números válidos.");
			}
		}
    }

    public static void main(String[] args) {
        suma();
    }
}
