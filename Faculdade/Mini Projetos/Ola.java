import java.util.Scanner;

public class Ola {
    // Método principal
    public static void main(String[] args) {
        // Solicita informações do usuário
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicita informações do usuário
            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();
            System.out.print("Digite sua cidade: ");
            String cidade = scanner.nextLine();
            System.out.print("Digite seu curso: ");
            String curso = scanner.nextLine();
            System.out.print("Digite sua idade: ");
            int idade = scanner.nextInt();
            // Exibe uma mensagem de boas-vindas
            exibirMensagemBoasVindas(nome, cidade, curso, idade);
            // Fecha o scanner
        }
    }

    // Método para exibir a mensagem de boas-vindas
    public static void exibirMensagemBoasVindas(String nome, String cidade, String curso, int idade) {
        System.out.println("🎉 Olá, " + nome + "! Seja bem-vindo(a) de " + cidade + "!");
        System.out.println("🎓 Você está cursando " + curso + " e tem " + idade + " anos.");
        System.out.println("Esperamos que você tenha uma experiência incrível! 🚀");
    }
}