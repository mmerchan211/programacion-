package nivel_4;

import java.util.Arrays;

public class Calcular_mediana {
    public static Double calcular_mediana(double... numeros) {
        if (numeros.length == 0) return null;
        Arrays.sort(numeros);
        int n = numeros.length;
        int mitad = n / 2;
        if (n % 2 == 0) {
            return (numeros[mitad - 1] + numeros[mitad]) / 2.0;
        } else {
            return numeros[mitad];
        }
    }

    public static void main(String[] args) {
        System.out.println("Mediana: " + calcular_mediana(4, 8, 12, 16, 20, 24));
    }
}
