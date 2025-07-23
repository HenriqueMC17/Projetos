public class ContagemRegressivaPares {
    public static void main(String[] args) {
        // Variável para armazenar a soma dos números pares
        int somaPares = 0;
        
        // Laço for para contagem regressiva
        // Inicialização: i = 10 - Define o valor inicial da variável de controle
        // Condição: i >= 1 - Continua o laço enquanto i for maior ou igual a 1
        // Decremento: i-- - Diminui o valor de i em 1 a cada iteração
        for(int i = 10; i >= 1; i--) {
            System.out.println("Número atual: " + i);
            
            // Verifica se o número é par usando o operador módulo (%)
            // Um número é par quando o resto da divisão por 2 é igual a 0
            if(i % 2 == 0) {
                System.out.println("  → Este número é par!");
                somaPares = somaPares + i; // Acumula a soma dos números pares
            }
        }
        
        // Exibe o resultado final
        System.out.println("\nA soma dos números pares é: " + somaPares);
        System.out.println("Fim da contagem regressiva!");
    }
} 