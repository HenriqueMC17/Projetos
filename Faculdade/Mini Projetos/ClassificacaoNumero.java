import java.util.Scanner;

public class ClassificacaoNumero {
    public static void main(String[] args) {
        // Criação do objeto Scanner para leitura de dados
        Scanner sc = new Scanner(System.in);
        
        // Solicita e lê o número do usuário
        System.out.print("Digite um número inteiro: ");
        int numero = sc.nextInt();
        
        // Estrutura condicional para classificar o número
        // Primeira condição: verifica se o número é maior que zero
        if (numero > 0) {
            System.out.println("O número " + numero + " é POSITIVO!");
        }
        // Segunda condição: verifica se o número é menor que zero
        else if (numero < 0) {
            System.out.println("O número " + numero + " é NEGATIVO!");
        }
        // Se nenhuma das condições acima for verdadeira, o número é zero
        else {
            System.out.println("O número " + numero + " é ZERO!");
        }
        
        // Fecha o Scanner para liberar recursos
        sc.close();
    }
} 