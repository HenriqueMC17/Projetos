package controller;

import model.AlbumModel;
import view.AlbumView;

/**
 * Classe Controller responsável por coordenar a interação entre Model e View
 * Implementa a lógica de controle do fluxo do programa
 */
public class AlbumController {
    private AlbumModel model;
    private AlbumView view;

    public AlbumController() {
        this.model = new AlbumModel();
        this.view = new AlbumView();
    }

    /**
     * Inicia o programa e gerencia o fluxo principal
     */
    public void iniciar() {
        boolean continuar = true;
        
        while (continuar) {
            view.exibirMenu();
            int opcao = view.lerOpcao();
            
            if (opcao == 0) {
                continuar = false;
                continue;
            }
            
            processarOpcao(opcao);
        }
        
        System.out.println("\n👋 Obrigado por usar o Álbum de Figurinhas!");
        view.fecharScanner();
    }

    /**
     * Processa a opção escolhida pelo usuário
     * @param opcao Opção selecionada no menu
     */
    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarFigurinhas();
                break;
            case 2:
                exibirAlbum();
                break;
            case 3:
                buscarJogador();
                break;
            case 4:
                ordenarAlbum();
                break;
            case 5:
                contarRepeticoes();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    /**
     * Processa o cadastro de novas figurinhas
     */
    private void cadastrarFigurinhas() {
        int quantidade = view.lerQuantidadeFigurinhas();
        String[] nomes = view.lerNomesJogadores(quantidade);
        model.cadastrarFigurinhas(nomes);
    }

    /**
     * Exibe o álbum completo
     */
    private void exibirAlbum() {
        view.exibirAlbum(model.getFigurinhas());
    }

    /**
     * Processa a busca de um jogador
     */
    private void buscarJogador() {
        if (model.estaVazio()) {
            System.out.println("\nÁlbum vazio. Cadastre figurinhas primeiro.");
            return;
        }
        
        String nome = view.lerNomeBusca();
        int posicao = model.buscarJogador(nome);
        view.exibirResultadoBusca(posicao, nome);
    }

    /**
     * Processa a ordenação do álbum
     */
    private void ordenarAlbum() {
        if (model.estaVazio()) {
            System.out.println("\nÁlbum vazio. Cadastre figurinhas primeiro.");
            return;
        }
        
        model.ordenarAlbum();
        view.exibirAlbumOrdenado(model.getFigurinhas());
    }

    /**
     * Processa a contagem de repetições de um jogador
     */
    private void contarRepeticoes() {
        if (model.estaVazio()) {
            System.out.println("\nÁlbum vazio. Cadastre figurinhas primeiro.");
            return;
        }
        
        String nome = view.lerNomeBusca();
        int quantidade = model.getQuantidadeJogador(nome);
        view.exibirQuantidadeRepeticoes(nome, quantidade);
    }
}