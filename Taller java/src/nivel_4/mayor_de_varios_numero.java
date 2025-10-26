package nivel_4;
public class mayor_de_varios_numero{ 
    public static Double mayor_de_varios_numeros(double... numeros) {
        if (numeros.length == 0) return null;
        double mayor = numeros[0];
        for (double n : numeros) {
            if (n > mayor) mayor = n;
        }
        return mayor;
    }

    public static void main(String[] args) {
        System.out.println("Mayor: " + mayor_de_varios_numeros(18, 25, 42, 2, 12, 30));
    }
}
