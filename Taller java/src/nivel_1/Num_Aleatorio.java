package nivel_1;

import java.util.Random;
import java.util.Scanner;

public class Num_Aleatorio {
    public static void num_aleatorio() {
        Random rnd = new Random();
        int objetivo = rnd.nextInt(100) + 1; // 0..99 +1 -> 1..100
        try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Adivina el número entre 1 y 100.");
			while (true) {
			    System.out.print("Tu intento: ");
			    String linea = sc.nextLine();
			    int intento;
			    try {
			        intento = Integer.parseInt(linea);
			    } catch (NumberFormatException e) {
			        System.out.println("Ingresa un número válido.");
			        continue;
			    }
			    if (intento < objetivo) {
			        System.out.println("El número es mayor.");
			    } else if (intento > objetivo) {
			        System.out.println("El número es menor.");
			    } else {
			        System.out.println("¡Felicitaciones, adivinaste el número!");
			        break;
			    }
			}
		}
    }

    public static void main(String[] args) {
        num_aleatorio();
    }
}
