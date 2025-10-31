package nivel_4;
import java.util.Scanner;
public class mayor_de_varios_numero{ 
     public static double mayor_de_varios_numero(double... nums) {
        if (nums.length == 0) throw new IllegalArgumentException("Se requieren al menos un número.");
        double mayor = nums[0];
        for (double v : nums) if (v > mayor) mayor = v;
        return mayor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese números separados por comas para encontrar el mayor: ");
        String entrada = sc.nextLine();
        String[] partes = entrada.split(",");
        double[] nums = new double[partes.length];
        for (int i = 0; i < partes.length; i++) nums[i] = Double.parseDouble(partes[i].trim());
        System.out.println("Mayor: " + mayordevariosnumero(nums));
        sc.close();
    }
}
