package nivel_2;
import java.util.Scanner;
public class Calcular_Media {
public static void calcularMedia() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese varios números separados por comas: ");
        String entrada = sc.nextLine();

        String[] partes = entrada.split(",");
        double suma = 0;
        for (String num : partes) {
            suma += Double.parseDouble(num.trim());
        }

        double media = suma / partes.length;
        System.out.println("La media de los números es: " + media);
    }

    public static void main(String[] args) {
        calcularMedia();
    }
}
