package nivel_2;

public class Palindromo {
     public static void palindromo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese una palabra para verificar si es palíndromo: ");
        String palabra = sc.nextLine();

        String invertida = new StringBuilder(palabra).reverse().toString();

        if (palabra.equalsIgnoreCase(invertida)) {
            System.out.println(" La palabra es un palíndromo.");
        } else {
            System.out.println("La palabra no es un palíndromo.");
        }
    }

    public static void main(String[] args) {
        palindromo();
    }
}

