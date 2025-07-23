// ===== view/ =====
// Importações necessárias para o funcionamento do programa
package util;

import java.util.Scanner;

import model.Categoria;
import view.Produto;

import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppSupermercado {
    public static void main(String[] args) {
        // ===== view/ =====
        // Inicialização do Scanner para entrada de dados do usuário
        Scanner sc = new Scanner(System.in);
        
        // ===== model/ =====
        // Listas para armazenar os dados do sistema
        List<Produto> produtos = new ArrayList<>();
        List<Categoria> categorias = new ArrayList<>();
        
        // Inicialização das categorias padrão
        categorias.add(new Categoria("Alimentos"));
        categorias.add(new Categoria("Bebidas"));
        categorias.add(new Categoria("Higiene"));
        
        // Variável para controlar o loop principal do menu
        int opcao;

        // ===== view/ =====
        // Loop principal do programa
        do {
            // Exibição do menu principal
            System.out.println("\n=== SISTEMA DO SUPERMERCADO INTELIGENTE ===");
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
            
            // Leitura da opção escolhida pelo usuário
            opcao = sc.nextInt();
            sc.nextLine(); // Limpeza do buffer do teclado

            // ===== controller/ =====
            // Switch para controlar o fluxo do programa baseado na opção escolhida
            switch (opcao) {
                case 1:
                    // ===== controller/ =====
                    // Cadastro de produtos usando while
                    System.out.println("\n=== CADASTRO DE PRODUTOS ===");
                    System.out.println("Digite o nome dos produtos (digite 'fim' para encerrar):");
                    
                    while (true) {
                        // Solicita nome do produto
                        System.out.print("Nome do produto: ");
                        String nome = sc.nextLine();
                        
                        // Verifica se deve encerrar o cadastro
                        if (nome.equalsIgnoreCase("fim")) {
                            break;
                        }
                        
                        // Solicita preço do produto
                        System.out.print("Preço do produto: R$ ");
                        double preco = sc.nextDouble();
                        sc.nextLine(); // Limpa o buffer
                        
                        // Solicita categoria do produto
                        System.out.println("Categorias disponíveis:");
                        for (int i = 0; i < categorias.size(); i++) {
                            System.out.println((i + 1) + ". " + categorias.get(i).getNome());
                        }
                        System.out.print("Escolha a categoria (número): ");
                        int catIndex = sc.nextInt() - 1;
                        sc.nextLine(); // Limpa o buffer
                        
                        // Cria e adiciona o novo produto
                        Produto novoProduto = new Produto(nome, preco, nome);
                        produtos.add(novoProduto);
                        
                        System.out.println("Produto cadastrado com sucesso!");
                    }
                    break;

                case 2:
                    // ===== controller/ =====
                    // Reajuste de preços
                    System.out.println("\n=== REAJUSTE DE PREÇOS ===");
                    System.out.println("Digite 5 preços para reajustar em 10%:");
                    
                    double[] precos = new double[5];
                    // Loop para ler os preços
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Preço " + (i + 1) + ": R$ ");
                        precos[i] = sc.nextDouble();
                    }
                    
                    // Aplica o reajuste e exibe os novos preços
                    System.out.println("\nPreços reajustados:");
                    for (int i = 0; i < 5; i++) {
                        precos[i] *= 1.10; // Aplica 10% de aumento
                        System.out.printf("Novo preço %d: R$ %.2f\n", (i + 1), precos[i]);
                    }
                    break;

                case 3:
                    // ===== controller/ =====
                    // Simulação de carrinho
                    System.out.println("\n=== SIMULAÇÃO DE CARRINHO ===");
                    double soma = 0;
                    int cont = 1;
                    
                    // Loop do-while para somar valores até ultrapassar R$100
                    do {
                        System.out.print("Digite o valor do produto " + cont + ": R$ ");
                        double valor = sc.nextDouble();
                        soma += valor;
                        cont++;
                        System.out.printf("Total atual: R$ %.2f\n", soma);
                    } while (soma <= 100);
                    
                    System.out.printf("\nTotal final do carrinho: R$ %.2f\n", soma);
                    break;

                case 4:
                    // ===== controller/ =====
                    // Validação de código promocional
                    System.out.println("\n=== CÓDIGO PROMOCIONAL ===");
                    String codigo;
                    
                    // Loop do-while para validar o código
                    do {
                        System.out.print("Digite o código promocional: ");
                        codigo = sc.nextLine();
                        
                        if (!codigo.equals("PROMO10")) {
                            System.out.println("Código incorreto. Tente novamente.");
                        }
                    } while (!codigo.equals("PROMO10"));
                    
                    System.out.println("Código válido! Promoção de 10% aplicada!");
                    break;

                case 5:
                    // ===== controller/ =====
                    // Aplicação de desconto para clientes
                    System.out.println("\n=== DESCONTO PARA CLIENTES ===");
                    System.out.println("Digite 5 valores para aplicar 10% de desconto:");
                    
                    // Loop para aplicar desconto em 5 valores
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Valor " + (i + 1) + ": R$ ");
                        double valor = sc.nextDouble();
                        double valorComDesconto = valor * 0.9; // Aplica 10% de desconto
                        System.out.printf("Valor com desconto: R$ %.2f\n", valorComDesconto);
                    }
                    break;

                case 6:
                    // ===== controller/ =====
                    // Ordenação de compras
                    System.out.println("\n=== ORDENAÇÃO DE COMPRAS ===");
                    System.out.println("Digite 6 valores de compras para ordenar:");
                    
                    double[] compras = new double[6];
                    // Loop para ler os valores
                    for (int i = 0; i < 6; i++) {
                        System.out.print("Valor " + (i + 1) + ": R$ ");
                        compras[i] = sc.nextDouble();
                    }
                    
                    // Ordena os valores
                    Arrays.sort(compras);
                    
                    // Exibe os valores ordenados
                    System.out.println("\nValores ordenados:");
                    for (double valor : compras) {
                        System.out.printf("R$ %.2f\n", valor);
                    }
                    break;

                case 7:
                    // ===== controller/ =====
                    // Soma por categoria
                    System.out.println("\n=== SOMA POR CATEGORIA ===");
                    
                    // Reinicia os totais das categorias
                    for (Categoria cat : categorias) {
                        cat.adicionarVenda(-cat.getTotalVendas()); // Zera o total
                    }
                    
                    // Loop para ler 10 valores e suas categorias
                    for (int i = 0; i < 10; i++) {
                        System.out.print("Digite o valor do produto " + (i + 1) + ": R$ ");
                        double valor = sc.nextDouble();
                        sc.nextLine(); // Limpa o buffer
                        
                        System.out.println("Categorias disponíveis:");
                        for (int j = 0; j < categorias.size(); j++) {
                            System.out.println((j + 1) + ". " + categorias.get(j).getNome());
                        }
                        System.out.print("Escolha a categoria (número): ");
                        int catIndex = sc.nextInt() - 1;
                        sc.nextLine(); // Limpa o buffer
                        
                        // Adiciona o valor à categoria escolhida
                        categorias.get(catIndex).adicionarVenda(valor);
                    }
                    
                    // Exibe os totais por categoria
                    System.out.println("\nTotais por categoria:");
                    for (Categoria cat : categorias) {
                        System.out.println(cat);
                    }
                    break;

                case 8:
                    // ===== controller/ =====
                    // Bônus: Salvar produtos em arquivo
                    System.out.println("\n=== SALVANDO PRODUTOS ===");
                    try {
                        FileWriter fw = new FileWriter("produtos.txt");
                        for (Produto p : produtos) {
                            fw.write(p.toString() + "\n");
                        }
                        fw.close();
                        System.out.println("Produtos salvos com sucesso em 'produtos.txt'!");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar arquivo: " + e.getMessage());
                    }
                    break;

                case 0:
                    // ===== view/ =====
                    // Encerramento do programa
                    System.out.println("\nEncerrando o sistema...");
                    break;

                default:
                    // ===== view/ =====
                    // Tratamento de opção inválida
                    System.out.println("\nOpção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        // ===== view/ =====
        // Fechamento do Scanner
        sc.close();
    }
}