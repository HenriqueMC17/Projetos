package com.exemplo.Controller;

import model.Formando;
import view.FormandoView;

public class FormandoController {
    private Formando model;
    private FormandoView view;

    public FormandoController() {
        this.model = new Formando();
        this.view = new FormandoView();
    }

    public void cadastrarFormando() {
        // Exibe mensagem de boas-vindas
        view.exibirBoasVindas();

        // Coleta dados do formando
        model.setNome(view.solicitarNome());
        model.setCurso(view.solicitarCurso());
        model.setCidade(view.solicitarCidade());
        model.setIdade(view.solicitarIdade());
        model.setBebidaPreferida(view.solicitarBebidaPreferida());
        model.setMusicaPreferida(view.solicitarMusicaPreferida());
        model.setComidaPreferida(view.solicitarComidaPreferida());
        model.setVaiTrazerConvidado(view.solicitarConvidado());

        // Exibe os dados cadastrados
        view.exibirFormando(model);

        // Exibe mensagem final
        view.exibirMensagemFinal();
    }
}