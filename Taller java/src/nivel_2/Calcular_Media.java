package nivel_2;

public class Calcular_Media {
    public static void calcular_media(double[] lista) {
        if (lista == null || lista.length == 0) {
            System.out.println("La lista está vacía.");
            return;
        }
        double suma = 0;
        for (double v : lista) suma += v;
        double media = suma / lista.length;
        System.out.println("La media es: " + media);
    }

    public static void main(String[] args) {
        calcular_media(new double[] {2,18,36,40});
    }
}
