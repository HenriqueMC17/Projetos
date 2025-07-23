package controller;

import model.VetorModel;
import view.VetorView;

public class VetorController {
    private VetorModel model;
    private VetorView view;

    public VetorController() {
        this.model = new VetorModel();
        this.view = new VetorView();
    }

    public void iniciar() {
        boolean continuar = true;
        
        while (continuar) {
            view.exibirMenu();
            int opcao = view.lerOpcao();
            
            if (opcao == 0) {
                continuar = false;
                continue;
            }
            
            // Sempre solicita novos números para cada operação
            int[] numeros = view.lerVetor();
            model.setNumeros(numeros);
            
            processarOpcao(opcao);
            
            continuar = view.confirmarContinuar();
        }
        
        view.exibirMensagem("\nPrograma finalizado. Obrigado!");
        view.fecharScanner();
    }

    private void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> processarMedia();
            case 2 -> processarOrdenacao();
            case 3 -> processarInversao();
            case 4 -> processarBusca();
            case 5 -> processarSomaParesImpares();
            case 6 -> processarMaiorMenor();
            default -> view.exibirMensagem("Opção inválida!");
        }
    }

    private void processarMedia() {
        double media = model.calcularMedia();
        view.exibirMedia(media);
    }

    private void processarOrdenacao() {
        model.ordenarVetor();
        view.exibirMensagem("\nVetor ordenado:");
        view.exibirVetor(model.getNumeros());
    }

    private void processarInversao() {
        int[] invertido = model.obterVetorInvertido();
        view.exibirMensagem("\nVetor invertido:");
        view.exibirVetor(invertido);
    }

    private void processarBusca() {
        int numero = view.lerNumeroBusca();
        int posicao = model.buscarNumero(numero);
        view.exibirResultadoBusca(posicao, numero);
    }

    private void processarSomaParesImpares() {
        int[] somas = model.calcularSomaParesImpares();
        view.exibirSomaParesImpares(somas);
    }

    private void processarMaiorMenor() {
        int[] extremos = model.encontrarMaiorMenor();
        view.exibirMaiorMenor(extremos);
    }

	public void iniciar1() {
		// TODO Auto-generated method stub
		
	}
}