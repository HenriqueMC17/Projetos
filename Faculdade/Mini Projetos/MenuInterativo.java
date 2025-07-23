import java.util.Scanner;

public class MenuInterativo {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcao;
            do {
                // Exibe o menu de opções
                System.out.println("Escolha um exercício para rodar:");
                System.out.println("1. Calculadora Simples");
                System.out.println("2. Faixa Etária");
                System.out.println("3. Maior Valor");
                System.out.println("4. Número Positivo, Negativo ou Zero");
                System.out.println("5. Classificador de Triângulo");
                System.out.println("6. Ano Bissexto");
                System.out.println("0. Sair");
                System.out.print("Digite a sua escolha: ");
                
                // Lê a opção do usuário
                opcao = scanner.nextInt();
                
                // Gerencia as opções usando switch
                switch (opcao) {
                    case 1:
                        // Chamar o método ou classe para Calculadora Simples
                        System.out.println("Executando Calculadora Simples...");
                        // CalculadoraSimples.main(args); // Descomente e ajuste conforme necessário
                        break;
                    case 2:
                        // Chamar o método ou classe para Faixa Etária
                        System.out.println("Executando Faixa Etária...");
                        // FaixaEtaria.main(args); // Descomente e ajuste conforme necessário
                        break;
                    case 3:
                        // Chamar o método ou classe para Maior Valor
                        System.out.println("Executando Maior Valor...");
                        // MaiorValor.main(args); // Descomente e ajuste conforme necessário
                        break;
                    case 4:
                        // Chamar o método ou classe para Número Positivo, Negativo ou Zero
                        System.out.println("Executando Número Positivo, Negativo ou Zero...");
                        // NumeroPositivoNegativoZero.main(args); // Descomente e ajuste conforme necessário
                        break;
                    case 5:
                        // Chamar o método ou classe para Classificador de Triângulo
                        System.out.println("Executando Classificador de Triângulo...");
                        // ClassificadorTriangulo.main(args); // Descomente e ajuste conforme necessário
                        break;
                    case 6:
                        // Chamar o método ou classe para Ano Bissexto
                        System.out.println("Executando Ano Bissexto...");
                        // AnoBissexto.main(args); // Descomente e ajuste conforme necessário
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente novamente.");
                }
            } while (opcao != 0);
            // Fecha o scanner
        }
    }
}