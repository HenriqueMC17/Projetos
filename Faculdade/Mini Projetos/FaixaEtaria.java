import java.util.Scanner;

public class FaixaEtaria {
    public static void main(String[] args) {
        // Solicita a idade da pessoa
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicita a idade da pessoa
            System.out.print("Digite a sua idade: ");
            int idade = scanner.nextInt();
            // Informa a faixa etária
            if (idade >= 0 && idade <= 12) {
                System.out.println("Criança");
            } else if (idade >= 13 && idade <= 17) {
                System.out.println("Adolescente");
            } else if (idade >= 18 && idade <= 59) {
                System.out.println("Adulto");
            } else if (idade >= 60) {
                System.out.println("Idoso");
            } else {
                System.out.println("Idade inválida!");
            }
            // Fecha o scanner
        }
    }
}