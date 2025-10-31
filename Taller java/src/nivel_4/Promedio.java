package nivel_4;
import java.util.Scanner;

public class Promedio {
    public static double promedio(double... nums) {
        if (nums.length == 0) throw new IllegalArgumentException("Se requieren al menos un número.");
        double suma = 0;
        for (double v : nums) suma += v;
        return suma / nums.length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa números separados por comas para calcular el promedio: ");
        String entrada = sc.nextLine();
        String[] partes = entrada.split(",");
        double[] nums = new double[partes.length];
        for (int i = 0; i < partes.length; i++) nums[i] = Double.parseDouble(partes[i].trim());
        System.out.println("Promedio: " + promedio(nums));
        sc.close();
    }
}
