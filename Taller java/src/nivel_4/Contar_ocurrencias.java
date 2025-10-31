package nivel_4;
import java.util.Scanner;

public class Contar_ocurrencias {
public static int Contar_ocurrencias(String cadena, String palabra) {
        if (palabra.isEmpty()) throw new IllegalArgumentException("La palabra a buscar no puede ser vacía.");
        String s = cadena.toLowerCase();
        String p = palabra.toLowerCase();
        int count = 0;
        int index = 0;
        while ((index = s.indexOf(p, index)) != -1) {
            count++;
            index += p.length(); // evita solapamiento
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cadena (texto): ");
        String texto = sc.nextLine();
        System.out.print("Ingrese la palabra a contar: ");
        String palabra = sc.nextLine();
        System.out.println("Ocurrencias: " + Contar_ocurrencias(texto, palabra));
        sc.close();
    }
}
