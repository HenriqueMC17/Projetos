package view;

import java.util.Scanner;

import model.Sanduiche;

public class SanduicheView {
    private Scanner scanner;

    public SanduicheView() {
        this.scanner = new Scanner(System.in);
    }

    public String solicitarPao() {
        System.out.println("\nEscolha o tipo de pão:");
        System.out.println("1 - Pão Francês");
        System.out.println("2 - Pão de Hambúrguer");
        System.out.println("3 - Pão Integral");
        
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer
        
        switch (opcao) {
            case 1: return "Pão Francês";
            case 2: return "Pão de Hambúrguer";
            case 3: return "Pão Integral";
            default: return "Pão Francês";
        }
    }

    public String solicitarProteina() {
        System.out.println("\nEscolha a proteína:");
        System.out.println("1 - Frango");
        System.out.println("2 - Carne");
        System.out.println("3 - Peixe");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcao) {
            case 1: return "Frango";
            case 2: return "Carne";
            case 3: return "Peixe";
            default: return "Frango";
        }
    }

    public String solicitarQueijo() {
        System.out.println("\nEscolha o queijo:");
        System.out.println("1 - Mussarela");
        System.out.println("2 - Prato");
        System.out.println("3 - Cheddar");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcao) {
            case 1: return "Mussarela";
            case 2: return "Prato";
            case 3: return "Cheddar";
            default: return "Mussarela";
        }
    }

    public String solicitarSalada() {
        System.out.println("\nEscolha a salada:");
        System.out.println("1 - Alface");
        System.out.println("2 - Tomate");
        System.out.println("3 - Cebola");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcao) {
            case 1: return "Alface";
            case 2: return "Tomate";
            case 3: return "Cebola";
            default: return "Alface";
        }
    }

    public String solicitarMolho() {
        System.out.println("\nEscolha o molho:");
        System.out.println("1 - Maionese");
        System.out.println("2 - Mostarda");
        System.out.println("3 - Barbecue");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcao) {
            case 1: return "Maionese";
            case 2: return "Mostarda";
            case 3: return "Barbecue";
            default: return "Maionese";
        }
    }

    public void exibirSanduiche(Sanduiche sanduiche) {
        System.out.println("\n" + sanduiche.toString());
    }
}