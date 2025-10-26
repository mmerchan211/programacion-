package nivel_4;

import java.util.Arrays;

public class Multiplicar_lista {
    public static double[] multiplicar_lista(double[] lista, double numero) {
        double[] nueva = new double[lista.length];
        for (int i = 0; i < lista.length; i++) {
            nueva[i] = lista[i] * numero;
        }
        return nueva;
    }

    public static void main(String[] args) {
        double[] resultado = multiplicar_lista(new double[]{42, 25, 18}, 12);
        System.out.println("Nueva lista: " + Arrays.toString(resultado));
    }
}
