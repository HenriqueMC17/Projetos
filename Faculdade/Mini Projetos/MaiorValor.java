import java.util.Scanner;

public class MaiorValor {
    public static void main(String[] args) {
        // Recebe dois números
        try (Scanner scanner = new Scanner(System.in)) {
            // Recebe dois números
            System.out.print("Digite o primeiro número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Digite o segundo número: ");
            double num2 = scanner.nextDouble();
            // Compara os números e informa qual é o maior
            if (num1 > num2) {
                System.out.println("O maior número é: " + num1);
            } else if (num2 > num1) {
                System.out.println("O maior número é: " + num2);
            } else {
                System.out.println("Os números são iguais.");
            }
            // Fecha o scanner
        }
    }
}