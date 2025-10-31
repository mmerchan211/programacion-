package nivel_4;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Multiplicar_lista {
    public static List<Double> multiplicarLista(List<Double> lista, double numero) {
        List<Double> res = new ArrayList<>();
        for (Double v : lista) res.add(v * numero);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese números separados por comas (lista): ");
        String entrada = sc.nextLine();
        String[] partes = entrada.split(",");
        List<Double> lista = new ArrayList<>();
        for (String p : partes) if (!p.trim().isEmpty()) lista.add(Double.parseDouble(p.trim()));

        System.out.print("Ingrese el número por el cual multiplicar la lista: ");
        double factor = sc.nextDouble();

        List<Double> resultado = multiplicarLista(lista, factor);
        System.out.println("Lista multiplicada: " + resultado);
        sc.close();
    }
}


