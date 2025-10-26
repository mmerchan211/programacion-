package nivel_2;

public class Calcular_Potencia {
    public static void calcular_potencia(double base, double exponente) {
        double resultado = Math.pow(base, exponente);
        System.out.println(base + " elevado a " + exponente + " es " + resultado);
    }

    public static void main(String[] args) {
        calcular_potencia(6,8);
    }
}
