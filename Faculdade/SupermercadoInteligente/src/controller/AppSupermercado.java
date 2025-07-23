package controller;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;

public class AppSupermercado {
    public static void main(String[] args) {
        // ===== view/ =====
        // Interface do usuário e menu principal
        Scanner sc = new Scanner(System.in);
        int opcao;

        // model/ - Vetores para armazenar dados
        String[] produtos = new String[100];
        int qtdProdutos = 0;
        double[] precos = new double[5];
        double[] compras = new double[6];
        double[] valoresCategoria = new double[10];
        String[] categorias = new String[10];

        do {
            System.out.println("=== SISTEMA DO SUPERMERCADO INTELIGENTE ===");
            System.out.println("1. Cadastrar produtos até digitar 'fim'");
            System.out.println("2. Reajustar preços");
            System.out.println("3. Simular carrinho");
            System.out.println("4. Verificar código promocional");
            System.out.println("5. Desconto para clientes");
            System.out.println("6. Ordenar compras");
            System.out.println("7. Soma por categoria");
            System.out.println("8. Salvar produtos em arquivo (BÔNUS)");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    // ===== controller/ =====
                    // Cadastro de produtos usando while
                    System.out.println("Digite o nome dos produtos (digite 'fim' para encerrar):");
                    String nome;
                    qtdProdutos = 0;
                    while (true) {
                        System.out.print("Produto " + (qtdProdutos + 1) + ": ");
                        nome = sc.nextLine();
                        if (nome.equalsIgnoreCase("fim")) break;
                        produtos[qtdProdutos] = nome;
                        qtdProdutos++;
                    }
                    System.out.println("Produtos cadastrados:");
                    for (int i = 0; i < qtdProdutos; i++) {
                        System.out.println("- " + produtos[i]);
                    }
                    break;

                case 2:
                    // ===== controller/ =====
                    // Reajuste de preços com for
                    System.out.println("Digite 5 preços para reajustar em 10%:");
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Preço " + (i + 1) + ": ");
                        precos[i] = sc.nextDouble();
                    }
                    System.out.println("Preços reajustados:");
                    for (int i = 0; i < 5; i++) {
                        precos[i] *= 1.10;
                        System.out.printf("Novo preço %d: R$ %.2f\n", (i + 1), precos[i]);
                    }
                    break;

                case 3:
                    // ===== controller/ =====
                    // Simulação de carrinho com do-while
                    double soma = 0;
                    int cont = 1;
                    do {
                        System.out.print("Digite o valor do produto " + cont + ": ");
                        double valor = sc.nextDouble();
                        soma += valor;
                        cont++;
                    } while (soma <= 100);
                    System.out.printf("Total do carrinho: R$ %.2f (ultrapassou R$100)\n", soma);
                    break;

                case 4:
                    // ===== controller/ =====
                    // Validação de código promocional com do-while
                    String codigo;
                    do {
                        System.out.print("Digite o código promocional: ");
                        codigo = sc.nextLine();
                        if (!codigo.equals("PROMO10")) {
                            System.out.println("Código incorreto. Tente novamente.");
                        }
                    } while (!codigo.equals("PROMO10"));
                    System.out.println("Código válido! Promoção aplicada.");
                    break;

                case 5:
                    // ===== controller/ =====
                    // Desconto para clientes
                    System.out.println("Digite 5 valores para aplicar 10% de desconto:");
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Valor " + (i + 1) + ": ");
                        double valor = sc.nextDouble();
                        double valorComDesconto = valor * 0.9;
                        System.out.printf("Com desconto: R$ %.2f\n", valorComDesconto);
                    }
                    break;

                case 6:
                    // ===== controller/ =====
                    // Ordenação de compras
                    System.out.println("Digite 6 valores de compras para ordenar:");
                    for (int i = 0; i < 6; i++) {
                        System.out.print("Compra " + (i + 1) + ": ");
                        compras[i] = sc.nextDouble();
                    }
                    Arrays.sort(compras);
                    System.out.println("Valores ordenados:");
                    for (double v : compras) {
                        System.out.printf("R$ %.2f\n", v);
                    }
                    break;

                case 7:
                    // ===== controller/ =====
                    // Soma por categoria
                    double totalAlimentos = 0, totalBebidas = 0, totalHigiene = 0;
                    for (int i = 0; i < 10; i++) {
                        System.out.print("Digite o valor do produto " + (i + 1) + ": ");
                        valoresCategoria[i] = sc.nextDouble();
                        sc.nextLine(); // Limpar buffer
                        System.out.print("Digite a categoria (alimento, bebida, higiene): ");
                        categorias[i] = sc.nextLine();
                        if (categorias[i].equalsIgnoreCase("alimento")) {
                            totalAlimentos += valoresCategoria[i];
                        } else if (categorias[i].equalsIgnoreCase("bebida")) {
                            totalBebidas += valoresCategoria[i];
                        } else if (categorias[i].equalsIgnoreCase("higiene")) {
                            totalHigiene += valoresCategoria[i];
                        }
                    }
                    System.out.printf("Total Alimentos: R$ %.2f\n", totalAlimentos);
                    System.out.printf("Total Bebidas: R$ %.2f\n", totalBebidas);
                    System.out.printf("Total Higiene: R$ %.2f\n", totalHigiene);
                    break;

                case 8:
                    // ===== controller/ =====
                    // BÔNUS: Salvar produtos em arquivo .txt
                    try {
                        FileWriter fw = new FileWriter("produtos.txt");
                        for (int i = 0; i < qtdProdutos; i++) {
                            fw.write(produtos[i] + "\n");
                        }
                        fw.close();
                        System.out.println("Produtos salvos em produtos.txt!");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar arquivo: " + e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println();
        } while (opcao != 0);

        sc.close();
    }
}