package controller;

import model.Sanduiche;
import view.SanduicheView;

public class SanduicheController {
    private Sanduiche model;
    private SanduicheView view;

    public SanduicheController() {
        this.model = new Sanduiche();
        this.view = new SanduicheView();
    }

    public void montarSanduiche() {
        // Preços base
        double precoPao = 5.0;
        double precoProteina = 8.0;
        double precoQueijo = 3.0;
        double precoSalada = 2.0;
        double precoMolho = 1.0;

        // Montagem do sanduíche
        model.setPao(view.solicitarPao());
        model.setProteina(view.solicitarProteina());
        model.setQueijo(view.solicitarQueijo());
        model.setSalada(view.solicitarSalada());
        model.setMolho(view.solicitarMolho());

        // Cálculo do preço
        double precoTotal = precoPao + precoProteina + precoQueijo + precoSalada + precoMolho;
        model.setPreco(precoTotal);

        // Exibição do resultado
        view.exibirSanduiche(model);
    }
}