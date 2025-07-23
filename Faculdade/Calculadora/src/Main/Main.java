package Main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> historico = new ArrayList<>();
        boolean continuar = true;

        while (continuar) {
            System.out.println("Escolha uma operação:");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Sair");

            int escolha = scanner.nextInt();

            if (escolha == 5) {
                continuar = false;
                break;
            }

            System.out.print("Digite o primeiro número: ");
            double num1 = scanner.nextDouble();
            System.out.print("Digite o segundo número: ");
            double num2 = scanner.nextDouble();

            double resultado = 0;
            String operacao = "";

            try {
                switch (escolha) {
                    case 1:
                        resultado = Calculadora.somar(num1, num2);
                        operacao = "Soma";
                        break;
                    case 2:
                        resultado = Calculadora.subtrair(num1, num2);
                        operacao = "Subtração";
                        break;
                    case 3:
                        resultado = Calculadora.multiplicar(num1, num2);
                        operacao = "Multiplicação";
                        break;
                    case 4:
                        resultado = Calculadora.dividir(num1, num2);
                        operacao = "Divisão";
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        continue;
                }
                String registro = operacao + ": " + num1 + " e " + num2 + " = " + resultado;
                historico.add(registro);
                System.out.println("Resultado: " + resultado);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Histórico de operações:");
        for (String registro : historico) {
            System.out.println(registro);
        }

        scanner.close();
    }
}