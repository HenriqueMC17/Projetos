package main;

import controller.SanduicheController;

public class main {
    public main(String[] args) {
        System.out.println("🍔 Bem-vindo ao Montador de Sanduíches! 🍔");
        System.out.println("Vamos criar seu sanduíche personalizado!");
        
        SanduicheController controller = new SanduicheController();
        controller.montarSanduiche();
    }
}