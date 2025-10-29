package nivel_2;
import java.util.Scanner;
public class Calcular_Potencia {
     public static void calcularPotencia() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la base: ");
        double base = sc.nextDouble();

        System.out.print("Ingrese el exponente: ");
        double exponente = sc.nextDouble();

        double resultado = Math.pow(base, exponente);
        System.out.println("El resultado de " + base + " elevado a " + exponente + " es: " + resultado);
    }

    public static void main(String[] args) {
        calcularPotencia();
    }
}
