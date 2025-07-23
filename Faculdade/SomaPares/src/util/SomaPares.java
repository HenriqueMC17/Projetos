package util;

import java.util.Scanner;

public class SomaPares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o valor de N: ");
        int n = sc.nextInt(); // Lê o valor inteiro de N

        int soma = 0; // Variável para armazenar a soma dos números pares

        // Laço for para iterar de 1 até N
        for (int i = 1; i <= n; i++) {
            // Verifica se o número é par
            if (i % 2 == 0) {
                soma += i; // Adiciona o número par à soma
            }
        }

        // Exibe o resultado final
        System.out.println("A soma de todos os números pares de 1 até " + n + " é: " + soma);

        sc.close(); // Fecha o Scanner
    }
}