package main;

import controller.AlbumController;

/**
 * Classe principal do programa Álbum de Figurinhas
 * Implementa um sistema de gerenciamento de álbum de figurinhas
 * com funcionalidades de cadastro, busca, ordenação e contagem
 */
public class AlbumDeFigurinhasComMenu {
    public static void main(String[] args) {
        AlbumController controller = new AlbumController();
        controller.iniciar();
    }
}