import java.util.Scanner;

public class ClassificadorTriangulo {
    public static void main(String[] args) {
        // Solicita os três lados do triângulo
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicita os três lados do triângulo
            System.out.print("Digite o primeiro lado do triângulo: ");
            double lado1 = scanner.nextDouble();
            System.out.print("Digite o segundo lado do triângulo: ");
            double lado2 = scanner.nextDouble();
            System.out.print("Digite o terceiro lado do triângulo: ");
            double lado3 = scanner.nextDouble();
            // Verifica o tipo de triângulo
            if (lado1 == lado2 && lado2 == lado3) {
                System.out.println("Triângulo Equilátero");
            } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
                System.out.println("Triângulo Isósceles");
            } else {
                System.out.println("Triângulo Escaleno");
            }
            // Fecha o scanner
        }
    }
}