package nivel_3;

import java.util.Scanner;

public class Calcular_Área {
      public static double calcular_area(double radio, double altura) {
        return 2 * Math.PI * radio * altura + 2 * Math.PI * radio * radio;
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Ingrese el radio del cilindro: ");
			double base = sc.nextDouble();
			System.out.print("Ingrese la altura del cilindro: ");
			double altura = sc.nextDouble();

			double area = calcular_area(base, altura);
			System.out.println("El área del cilindro es: " + area);
		}
    }
}
