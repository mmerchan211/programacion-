package nivel_4;

public class Promedio {
    public static Double promedio(double... numeros) {
        if (numeros.length == 0) return null;
        double suma = 0;
        for (double n : numeros) suma += n;
        return suma / numeros.length;
    }

    public static void main(String[] args) {
        System.out.println("Promedio: " + promedio(3.6, 1.8, 3.9, 1));
    }
}
