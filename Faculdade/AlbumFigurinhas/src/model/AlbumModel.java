package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe Model responsável por gerenciar os dados do álbum de figurinhas
 * Implementa a lógica de negócio para manipulação das figurinhas
 */
public class AlbumModel {
    private String[] figurinhas;
    private Map<String, Integer> contagemFigurinhas;

    public AlbumModel() {
        this.figurinhas = new String[0];
        this.contagemFigurinhas = new HashMap<>();
    }

    /**
     * Cadastra novas figurinhas no álbum
     * @param novasFigurinhas Array com os nomes dos jogadores
     */
    public void cadastrarFigurinhas(String[] novasFigurinhas) {
        this.figurinhas = novasFigurinhas;
        atualizarContagem();
    }

    /**
     * Retorna uma cópia do array de figurinhas
     */
    public String[] getFigurinhas() {
        return Arrays.copyOf(figurinhas, figurinhas.length);
    }

    /**
     * Busca um jogador no álbum
     * @param nome Nome do jogador a ser buscado
     * @return Posição do jogador ou -1 se não encontrado
     */
    public int buscarJogador(String nome) {
        for (int i = 0; i < figurinhas.length; i++) {
            if (figurinhas[i].equalsIgnoreCase(nome.trim())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Ordena o álbum em ordem alfabética
     */
    public void ordenarAlbum() {
        Arrays.sort(figurinhas, String.CASE_INSENSITIVE_ORDER);
    }

    /**
     * Retorna a quantidade de vezes que um jogador aparece no álbum
     * @param nome Nome do jogador
     * @return Quantidade de ocorrências
     */
    public int getQuantidadeJogador(String nome) {
        return contagemFigurinhas.getOrDefault(nome.toLowerCase(), 0);
    }

    /**
     * Atualiza o mapa de contagem de figurinhas
     */
    private void atualizarContagem() {
        contagemFigurinhas.clear();
        for (String figurinha : figurinhas) {
            String nome = figurinha.toLowerCase();
            contagemFigurinhas.put(nome, contagemFigurinhas.getOrDefault(nome, 0) + 1);
        }
    }

    /**
     * Verifica se o álbum está vazio
     */
    public boolean estaVazio() {
        return figurinhas.length == 0;
    }
}