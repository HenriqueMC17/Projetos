package view;

import java.util.Scanner;

public class VetorView {
    private Scanner scanner;

    public VetorView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        System.out.println("\n=== MENU DE OPERAÇÕES COM VETORES ===");
        System.out.println("1. Calcular Média");
        System.out.println("2. Ordenar Vetor");
        System.out.println("3. Inverter Vetor");
        System.out.println("4. Buscar Número");
        System.out.println("5. Soma de Pares e Ímpares");
        System.out.println("6. Maior e Menor Valor");
        System.out.println("0. Sair");
        System.out.print("\nEscolha uma opção: ");
    }

    public int lerOpcao() {
        while (true) {
            try {
                int opcao = Integer.parseInt(scanner.nextLine().trim());
                if (opcao >= 0 && opcao <= 6) {
                    return opcao;
                }
                System.out.print("Opção inválida. Digite um número entre 0 e 6: ");
            } catch (NumberFormatException e) {
                System.out.print("Por favor, digite um número válido: ");
            }
        }
    }

    public int[] lerVetor() {
        int[] numeros = new int[5];
        System.out.println("\nDigite 5 números inteiros:");
        
        for (int i = 0; i < numeros.length; i++) {
            while (true) {
                try {
                    System.out.printf("Número %d: ", (i + 1));
                    numeros[i] = Integer.parseInt(scanner.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Por favor, digite um número inteiro válido: ");
                }
            }
        }
        return numeros;
    }

    public int lerNumeroBusca() {
        while (true) {
            try {
                System.out.print("\nDigite o número a ser buscado: ");
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Por favor, digite um número inteiro válido: ");
            }
        }
    }

    public void exibirVetor(int[] vetor) {
        System.out.print("\nVetor: [");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i]);
            if (i < vetor.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void exibirMedia(double media) {
        System.out.printf("\nMédia dos números: %.2f%n", media);
    }

    public void exibirResultadoBusca(int posicao, int numero) {
        if (posicao != -1) {
            System.out.printf("\nO número %d foi encontrado na posição %d.%n", numero, posicao);
        } else {
            System.out.printf("\nO número %d não foi encontrado no vetor.%n", numero);
        }
    }

    public void exibirSomaParesImpares(int[] somas) {
        System.out.printf("\nSoma dos números pares: %d%n", somas[0]);
        System.out.printf("Soma dos números ímpares: %d%n", somas[1]);
    }

    public void exibirMaiorMenor(int[] extremos) {
        System.out.printf("\nMaior valor: %d%n", extremos[0]);
        System.out.printf("Menor valor: %d%n", extremos[1]);
    }

    public boolean confirmarContinuar() {
        System.out.print("\nDeseja continuar? (s/n): ");
        String resposta = scanner.nextLine().trim().toLowerCase();
        return resposta.equals("s") || resposta.equals("sim");
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void fecharScanner() {
        scanner.close();
    }
}