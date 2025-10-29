package nivel_1;

import java.util.Scanner; //leer datos de entrada del usuario 

public class Preguntar_edad {
    public static void edad() {
        try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Ingresa tu edad: ");
			String s = sc.nextLine();
			try {
			    int edad = Integer.parseInt(s.trim());
			    System.out.println("Tu edad es " + edad + " años");
			} catch (NumberFormatException e) {
			    System.out.println("No ingresaste un número válido.");
			}
		}
    }
    public static void main(String[] args) {
        edad();
    }
}

