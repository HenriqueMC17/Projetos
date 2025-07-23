import java.util.Scanner;

public class NumeroPositivoNegativoZero {
    public static void main(String[] args) {
        // Solicita um número ao usuário
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicita um número ao usuário
            System.out.print("Digite um número: ");
            double numero = scanner.nextDouble();
            // Informa se o número é positivo, negativo ou zero
            if (numero > 0) {
                System.out.println("O número é positivo.");
            } else if (numero < 0) {
                System.out.println("O número é negativo.");
            } else {
                System.out.println("O número é zero.");
            }
            // Fecha o scanner
        }
    }
}