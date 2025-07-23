import java.util.Scanner;

public class ParOuImpar {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            char continuar;
            do {
                // Solicita um número inteiro do usuário
                System.out.print("Digite um número inteiro: ");
                int numero = scanner.nextInt();
                
                // Verifica se o número é par ou ímpar
                if (numero % 2 == 0) {
                    System.out.println("✅ O número " + numero + " é par! 🎉");
                } else {
                    System.out.println("❌ O número " + numero + " é ímpar! 🎈");
                }
                
                // Pergunta se o usuário deseja continuar
                System.out.print("Deseja verificar outro número? (s/n): ");
                continuar = scanner.next().charAt(0);
            } while (continuar == 's' || continuar == 'S');
            // Fecha o scanner
        }
    }
}