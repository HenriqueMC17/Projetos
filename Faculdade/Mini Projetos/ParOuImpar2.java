public class ParOuImpar2 {
    public static String verificarParOuImpar(int n) {
        if ((n & 1) == 0) {
            return "Par";
        } else {
            return "Ímpar";
        }
    }

    public static void main(String[] args) {
        System.out.println(verificarParOuImpar(4)); // Par
        System.out.println(verificarParOuImpar(7)); // Ímpar
    }
}