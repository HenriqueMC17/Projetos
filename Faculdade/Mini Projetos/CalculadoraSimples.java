import java.util.Scanner;

public class CalculadoraSimples {
    public static void main(String[] args) {
        // Solicita dois números ao usuário
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicita dois números ao usuário
            System.out.print("Digite o primeiro número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Digite o segundo número: ");
            double num2 = scanner.nextDouble();
            // Pede que ele escolha uma operação
            System.out.print("Escolha uma operação (+, -, *, /): ");
            char operacao = scanner.next().charAt(0);
            double resultado;
            // Estrutura condicional para realizar a operação escolhida
            switch (operacao) {
                case '+':
                    resultado = num1 + num2;
                    break;
                case '-':
                    resultado = num1 - num2;
                    break;
                case '*':
                    resultado = num1 * num2;
                    break;
                case '/':
                    if (num2 != 0) {
                        resultado = num1 / num2;
                    } else {
                        System.out.println("Erro: Divisão por zero!");
                        scanner.close();
                        return;
                    }   break;
                default:
                    System.out.println("Operação inválida!");
                    scanner.close();
                    return;
            }   // Exibe o resultado da operação
            System.out.println("O resultado é: " + resultado);
            // Fecha o scanner
        }
    }
}