import java.util.Scanner;

public class Aula9RepeticaoCondicional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("=== MENU DE EXERCÍCIOS ===");
            System.out.println("1. Somar números até digitar negativo");
            System.out.println("2. Calcular média até digitar zero");
            System.out.println("3. Somar até passar de 100");
            System.out.println("4. Validação de senha (senha fixa)");
            System.out.println("5. Máquina de vendas (valor do produto)");
            System.out.println("6. Calcular fatorial de um número");
            System.out.println("7. Calculadora (com do...while)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            while (!sc.hasNextInt()) {
                System.out.print("Opção inválida. Digite um número: ");
                sc.next();
            }
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    somarAteNegativo(sc);
                    break;
                case 2:
                    mediaAteZero(sc);
                    break;
                case 3:
                    somarAteCem(sc);
                    break;
                case 4:
                    validarSenha(sc);
                    break;
                case 5:
                    maquinaVendas(sc);
                    break;
                case 6:
                    calcularFatorial(sc);
                    break;
                case 7:
                    calculadora(sc);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println();
        } while (opcao != 0);
        sc.close();
    }

    // Exercício 1
    public static void somarAteNegativo(Scanner sc) {
        int soma = 0;
        int num;
        System.out.println("Digite números positivos para somar. Digite um número negativo para sair.");
        while (true) {
            System.out.print("Número: ");
            while (!sc.hasNextInt()) {
                System.out.print("Entrada inválida. Digite um número inteiro: ");
                sc.next();
            }
            num = sc.nextInt();
            if (num < 0) break;
            soma += num;
        }
        System.out.println("Soma total: " + soma);
    }

    // Exercício 2
    public static void mediaAteZero(Scanner sc) {
        int soma = 0, count = 0, num;
        System.out.println("Digite números para calcular a média. Digite zero para finalizar.");
        while (true) {
            System.out.print("Número: ");
            while (!sc.hasNextInt()) {
                System.out.print("Entrada inválida. Digite um número inteiro: ");
                sc.next();
            }
            num = sc.nextInt();
            if (num == 0) break;
            soma += num;
            count++;
        }
        if (count > 0) {
            double media = (double) soma / count;
            System.out.println("Média: " + media);
        } else {
            System.out.println("Nenhum número válido foi digitado.");
        }
    }

    // Exercício 3
    public static void somarAteCem(Scanner sc) {
        int soma = 0, num;
        System.out.println("Digite números para somar até ultrapassar 100.");
        while (soma <= 100) {
            System.out.print("Número: ");
            while (!sc.hasNextInt()) {
                System.out.print("Entrada inválida. Digite um número inteiro: ");
                sc.next();
            }
            num = sc.nextInt();
            soma += num;
        }
        System.out.println("A soma ultrapassou 100! Soma final: " + soma);
    }

    // Exercício 4
    public static void validarSenha(Scanner sc) {
        final String SENHA_FIXA = "1234";
        String senha;
        do {
            System.out.print("Digite a senha: ");
            senha = sc.next();
            if (!senha.equals(SENHA_FIXA)) {
                System.out.println("Senha incorreta. Tente novamente.");
            }
        } while (!senha.equals(SENHA_FIXA));
        System.out.println("Acesso liberado!");
    }

    // Exercício 5
    public static void maquinaVendas(Scanner sc) {
        final double VALOR_PRODUTO = 7.50;
        double total = 0.0;
        System.out.println("Produto custa R$ " + VALOR_PRODUTO);
        while (total < VALOR_PRODUTO) {
            System.out.print("Insira um valor: ");
            while (!sc.hasNextDouble()) {
                System.out.print("Entrada inválida. Digite um valor válido: ");
                sc.next();
            }
            double valor = sc.nextDouble();
            if (valor <= 0) {
                System.out.println("Valor deve ser positivo.");
                continue;
            }
            total += valor;
            System.out.printf("Total inserido: R$ %.2f\n", total);
        }
        double troco = total - VALOR_PRODUTO;
        System.out.printf("Troco: R$ %.2f\n", troco);
    }

    // Exercício 6
    public static void calcularFatorial(Scanner sc) {
        int num;
        do {
            System.out.print("Digite um número inteiro não-negativo: ");
            while (!sc.hasNextInt()) {
                System.out.print("Entrada inválida. Digite um número inteiro: ");
                sc.next();
            }
            num = sc.nextInt();
            if (num < 0) {
                System.out.println("Número deve ser não-negativo.");
            }
        } while (num < 0);
        long fatorial = 1;
        for (int i = 2; i <= num; i++) {
            fatorial *= i;
        }
        System.out.println("Fatorial de " + num + " = " + fatorial);
    }

    // Exercício 7
    public static void calculadora(Scanner sc) {
        char continuar;
        do {
            double num1, num2, resultado = 0;
            char operacao;
            System.out.print("Digite o primeiro número: ");
            while (!sc.hasNextDouble()) {
                System.out.print("Entrada inválida. Digite um número: ");
                sc.next();
            }
            num1 = sc.nextDouble();
            System.out.print("Digite a operação (+, -, *, /): ");
            operacao = sc.next().charAt(0);
            System.out.print("Digite o segundo número: ");
            while (!sc.hasNextDouble()) {
                System.out.print("Entrada inválida. Digite um número: ");
                sc.next();
            }
            num2 = sc.nextDouble();
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
                    if (num2 == 0) {
                        System.out.println("Não é possível dividir por zero.");
                        continue;
                    }
                    resultado = num1 / num2;
                    break;
                default:
                    System.out.println("Operação inválida.");
                    continue;
            }
            System.out.println("Resultado: " + resultado);
            System.out.print("Deseja realizar outra operação? (s/n): ");
            String resposta = sc.next().toLowerCase();
            continuar = resposta.charAt(0);
        } while (continuar == 's');
    }
} 