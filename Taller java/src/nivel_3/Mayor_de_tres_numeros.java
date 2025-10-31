package nivel_3;
import java.util.Scanner;

public class Mayor_de_tres_numeros {
    public static double mayorDeTresNumeros(double n1, double n2, double n3) {
        return Math.max(n1, Math.max(n2, n3));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el primer número: ");
        double a = sc.nextDouble();
        System.out.print("Ingresa el segundo número: ");
        double b = sc.nextDouble();
        System.out.print("Ingresa el tercer número: ");
        double c = sc.nextDouble();

        double mayor = mayorDeTresNumeros(a, b, c);
        System.out.println("El número mayor es: " + mayor);
        sc.close();
    }
}

