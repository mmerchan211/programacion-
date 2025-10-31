package nivel_4;
import java.util.Arrays;
import java.util.Scanner;

public class Calcular_mediana {
    public static double calcular_mediana(double... nums) {
        if (nums.length == 0) throw new IllegalArgumentException("Se requieren al menos un número.");
        double[] copia = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copia);
        int n = copia.length;
        if (n % 2 == 1) return copia[n / 2];
        else return (copia[n/2 - 1] + copia[n/2]) / 2.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese números separados por comas para calcular la mediana: ");
        String entrada = sc.nextLine();
        String[] partes = entrada.split(",");
        double[] nums = new double[partes.length];
        for (int i = 0; i < partes.length; i++) nums[i] = Double.parseDouble(partes[i].trim());
        System.out.println("Mediana: " + calcular_mediana(nums));
        sc.close();
    }
}
