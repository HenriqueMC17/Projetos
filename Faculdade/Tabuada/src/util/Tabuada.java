package util;
import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite um número para a tabuada: ");
        int num = sc.nextInt(); // Lê o número inteiro do usuário

        // Laço for para calcular e imprimir a tabuada
        for (int i = 1; i <= 10; i++) { // i é a variável de incremento, começando em 1 e indo até 10
            int resultado = num * i; // Calcula o resultado da multiplicação
            System.out.println(num + " x " + i + " = " + resultado); // Imprime a multiplicação formatada
        }

        sc.close(); // Fecha o Scanner
    }
}