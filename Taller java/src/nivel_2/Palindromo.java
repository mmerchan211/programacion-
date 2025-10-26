package nivel_2;

public class Palindromo {
    public static boolean palindromo(String palabra) {
        StringBuilder sb = new StringBuilder();
        for (char c : palabra.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(c)) sb.append(c);
        }
        String s = sb.toString();
        String rev = new StringBuilder(s).reverse().toString();
        return s.equals(rev);
    }

    public static void main(String[] args) {
        System.out.println(palindromo("Somos o no somos")); 
    }
}
