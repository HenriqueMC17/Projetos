package view;

import java.util.Scanner;

/**
 * Classe View responsável pela interface com o usuário
 * Gerencia todas as entradas e saídas do programa
 */
public class AlbumView {
    private Scanner scanner;

    public AlbumView() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Exibe o menu principal do álbum
     */
    public void exibirMenu() {
        System.out.println("\n=== MENU DO ÁLBUM DE FIGURINHAS ===");
        System.out.println("1. Cadastrar Figurinhas");
        System.out.println("2. Exibir Álbum Completo");
        System.out.println("3. Buscar Jogador");
        System.out.println("4. Ordenar em Ordem Alfabética");
        System.out.println("5. Contar Repetições");
        System.out.println("0. Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    /**
     * Lê a opção escolhida pelo usuário
     * @return Opção válida (0-5)
     */
    public int lerOpcao() {
        while (true) {
            try {
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                if (opcao >= 0 && opcao <= 5) {
                    return opcao;
                }
                System.out.print("Opção inválida. Digite um número entre 0 e 5: ");
            } catch (NumberFormatException e) {
                System.out.print("Por favor, digite um número válido: ");
            }
        }
    }

    /**
     * Lê a quantidade de figurinhas a serem cadastradas
     * @return Quantidade válida (maior que zero)
     */
    public int lerQuantidadeFigurinhas() {
        while (true) {
            try {
                System.out.print("Quantas figurinhas deseja cadastrar? ");
                int quantidade = Integer.parseInt(scanner.nextLine().trim());
                if (quantidade > 0) {
                    return quantidade;
                }
                System.out.println("A quantidade deve ser maior que zero!");
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido!");
            }
        }
    }

    /**
     * Lê os nomes dos jogadores para cadastro
     * @param quantidade Quantidade de figurinhas a cadastrar
     * @return Array com os nomes dos jogadores
     */
    public String[] lerNomesJogadores(int quantidade) {
        String[] nomes = new String[quantidade];
        System.out.println("\nDigite os nomes dos jogadores:");
        
        for (int i = 0; i < quantidade; i++) {
            System.out.printf("Jogador %d: ", (i + 1));
            String nome = scanner.nextLine().trim();
            while (nome.isEmpty()) {
                System.out.print("Nome não pode ser vazio! Digite novamente: ");
                nome = scanner.nextLine().trim();
            }
            nomes[i] = nome;
        }
        
        System.out.println("\n✅ Cadastro concluído!");
        return nomes;
    }

    /**
     * Exibe o álbum completo
     * @param figurinhas Array com as figurinhas cadastradas
     */
    public void exibirAlbum(String[] figurinhas) {
        if (figurinhas.length == 0) {
            System.out.println("\nÁlbum vazio. Cadastre figurinhas primeiro.");
            return;
        }

        System.out.println("\n=== ÁLBUM COMPLETO ===");
        for (int i = 0; i < figurinhas.length; i++) {
            System.out.printf("Figurinha [%d] = %s%n", i, figurinhas[i]);
        }
    }

    /**
     * Lê o nome do jogador a ser buscado
     * @return Nome do jogador
     */
    public String lerNomeBusca() {
        System.out.print("\nDigite o nome a buscar: ");
        return scanner.nextLine().trim();
    }

    /**
     * Exibe o resultado da busca
     * @param posicao Posição do jogador no álbum (-1 se não encontrado)
     * @param nome Nome do jogador buscado
     */
    public void exibirResultadoBusca(int posicao, String nome) {
        if (posicao != -1) {
            System.out.printf("\n✅ %s está na posição [%d].%n", nome, posicao);
        } else {
            System.out.printf("\n❌ %s não foi encontrado no álbum.%n", nome);
        }
    }

    /**
     * Exibe o álbum ordenado
     * @param figurinhas Array com as figurinhas ordenadas
     */
    public void exibirAlbumOrdenado(String[] figurinhas) {
        if (figurinhas.length == 0) {
            System.out.println("\nÁlbum vazio. Cadastre figurinhas primeiro.");
            return;
        }

        System.out.println("\n🔠 Álbum em ordem alfabética:");
        for (String figurinha : figurinhas) {
            System.out.println("➤ " + figurinha);
        }
    }

    /**
     * Exibe a quantidade de repetições de um jogador
     * @param nome Nome do jogador
     * @param quantidade Quantidade de repetições
     */
    public void exibirQuantidadeRepeticoes(String nome, int quantidade) {
        if (quantidade > 0) {
            System.out.printf("\n📊 O jogador %s aparece %d vez(es) no álbum.%n", nome, quantidade);
        } else {
            System.out.printf("\n❌ O jogador %s não foi encontrado no álbum.%n", nome);
        }
    }

    /**
     * Fecha o scanner
     */
    public void fecharScanner() {
        scanner.close();
    }
}