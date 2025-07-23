import java.util.Scanner;

public class AnoBissexto {
    public static void main(String[] args) {
        // Pede um ano qualquer
        try (Scanner scanner = new Scanner(System.in)) {
            // Pede um ano qualquer
            System.out.print("Digite um ano: ");
            int ano = scanner.nextInt();
            // Verifica se o ano é bissexto
            if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                System.out.println("O ano é bissexto.");
            } else {
                System.out.println("O ano não é bissexto.");
            }
            // Fecha o scanner
        }
    }
}