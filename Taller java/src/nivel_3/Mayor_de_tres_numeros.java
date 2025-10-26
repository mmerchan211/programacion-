package nivel_3;
public class Mayor_de_tres_numeros {
    public static double mayor_de_tres_numeros(double a, double b, double c) {
        return Math.max(a, Math.max(b, c));
    }
    public static void main(String[] args) {
        System.out.println(mayor_de_tres_numeros(78,48,102));
    }
}

