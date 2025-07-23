package main;
import java.util.Scanner;

public class AppCalculadora {
	
	public static double somar(double a, double b) {
		return a + b;
	}
	
	public static double subtrair(double a, double b) {
		return a - b;
	}
	
	public static double multiplicar(double a, double b) {
		return a * b;
	}
	
	public static double divisão(double a, double b) {
		return a / b;
	}
	
	public static void main(String[] args) {
		
		Scanner jubileu = new Scanner(System.in);
		int opcao;
		
		do {
			System.out.println("\n Calculadora Soma em Java");
			System.out.println("-------------------------");
			System.out.println("1 - Adição");
			System.out.println("2 - Subtração");
			System.out.println("3 - Multiplicação");
			System.out.println("4 - Divisão");
			System.out.println("0 - Sair");
			System.out.println("Escolha uma opção: ");
			opcao = jubileu.nextInt();
			
			if (opcao == 0) {
				System.out.println("Obrigado por usar a calculadora!");
				break;
			}
			
			System.out.println("Digite o primeiro número: ");
			double n1 = jubileu.nextDouble();
			
			System.out.println("Digite o segundo número: ");
			double n2 = jubileu.nextDouble();
			
			double resultado = 0;
			
			switch (opcao) {
			
				case 1:
					resultado = somar(n1, n2);
					System.out.println("Resultado da soma: " + resultado);
				break;
				
				case 2:
					resultado = subtrair(n1, n2);
					System.out.println("Resultado da soma: " + resultado);
				break;
				
				case 3:
					resultado = multiplicar(n1, n2);
					System.out.println("Resultado da soma: " + resultado);
				break;
				
				case 4:
					resultado = divisão(n1, n2);
					System.out.println("Resultado da soma: " + resultado);
				break;
					
				default:
					System.err.println("Opção inválida! Tente novamente.");
				break;
			}
		} while (opcao != 0);
		
		jubileu.close();
	}
}