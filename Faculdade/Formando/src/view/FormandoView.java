package view;

import java.util.Scanner;

import model.Formando;

public class FormandoView {
    private Scanner scanner;

    public FormandoView() {
        this.scanner = new Scanner(System.in);
    }

    public void exibirBoasVindas() {
        System.out.println("\n🎉 Bem-vindo ao Sistema de Cadastro da Festa de Formatura! 🎉");
        System.out.println("Vamos cadastrar os formandos para nossa festa incrível!\n");
    }

    public String solicitarNome() {
        System.out.print("👤 Digite o nome do formando: ");
        return scanner.nextLine();
    }

    public String solicitarCurso() {
        System.out.println("\n📚 Escolha o curso:");
        System.out.println("1 - Engenharia de Software");
        System.out.println("2 - Ciência da Computação");
        System.out.println("3 - Sistemas de Informação");
        System.out.println("4 - Outro");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcao) {
            case 1: return "Engenharia de Software";
            case 2: return "Ciência da Computação";
            case 3: return "Sistemas de Informação";
            case 4: 
                System.out.print("Digite o nome do curso: ");
                return scanner.nextLine();
            default: return "Engenharia de Software";
        }
    }

    public String solicitarCidade() {
        System.out.print("\n🏙️ Digite a cidade de origem: ");
        return scanner.nextLine();
    }

    public int solicitarIdade() {
        System.out.print("\n🎂 Digite a idade: ");
        return scanner.nextInt();
    }

    public String solicitarBebidaPreferida() {
        System.out.println("\n🥤 Escolha a bebida preferida:");
        System.out.println("1 - Refrigerante");
        System.out.println("2 - Suco Natural");
        System.out.println("3 - Água");
        System.out.println("4 - Outro");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcao) {
            case 1: return "Refrigerante";
            case 2: return "Suco Natural";
            case 3: return "Água";
            case 4: 
                System.out.print("Digite a bebida preferida: ");
                return scanner.nextLine();
            default: return "Refrigerante";
        }
    }

    public String solicitarMusicaPreferida() {
        System.out.println("\n🎵 Escolha o estilo de música preferido:");
        System.out.println("1 - Pop");
        System.out.println("2 - Rock");
        System.out.println("3 - Sertanejo");
        System.out.println("4 - Outro");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcao) {
            case 1: return "Pop";
            case 2: return "Rock";
            case 3: return "Sertanejo";
            case 4: 
                System.out.print("Digite o estilo de música preferido: ");
                return scanner.nextLine();
            default: return "Pop";
        }
    }

    public String solicitarComidaPreferida() {
        System.out.println("\n🍽️ Escolha a comida preferida:");
        System.out.println("1 - Pizza");
        System.out.println("2 - Salgados");
        System.out.println("3 - Doces");
        System.out.println("4 - Outro");
        
        int opcao = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcao) {
            case 1: return "Pizza";
            case 2: return "Salgados";
            case 3: return "Doces";
            case 4: 
                System.out.print("Digite a comida preferida: ");
                return scanner.nextLine();
            default: return "Pizza";
        }
    }

    public boolean solicitarConvidado() {
        System.out.print("\n👥 Vai trazer um convidado? (s/n): ");
        String resposta = scanner.nextLine().toLowerCase();
        return resposta.equals("s") || resposta.equals("sim");
    }

    public void exibirFormando(Formando formando) {
        System.out.println("\n" + formando.toString());
    }

    public void exibirMensagemFinal() {
        System.out.println("\n🎊 Cadastro realizado com sucesso! Vejo você na festa! 🎊");
    }
}