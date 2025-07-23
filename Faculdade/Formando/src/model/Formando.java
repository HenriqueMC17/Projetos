package model;

public class Formando {
	
    private String nome;
    private String curso;
    private String cidade;
    private int idade;
    private String bebidaPreferida;
    private String musicaPreferida;
    private String comidaPreferida;
    private boolean vaiTrazerConvidado;

    public Formando() {
        this.nome = "";
        this.curso = "";
        this.cidade = "";
        this.idade = 0;
        this.bebidaPreferida = "";
        this.musicaPreferida = "";
        this.comidaPreferida = "";
        this.vaiTrazerConvidado = false;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCurso() { return curso; }
    public void setCurso(String curso) { this.curso = curso; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public int getIdade() { return idade; }
    public void setIdade(int idade) { this.idade = idade; }

    public String getBebidaPreferida() { return bebidaPreferida; }
    public void setBebidaPreferida(String bebidaPreferida) { this.bebidaPreferida = bebidaPreferida; }

    public String getMusicaPreferida() { return musicaPreferida; }
    public void setMusicaPreferida(String musicaPreferida) { this.musicaPreferida = musicaPreferida; }

    public String getComidaPreferida() { return comidaPreferida; }
    public void setComidaPreferida(String comidaPreferida) { this.comidaPreferida = comidaPreferida; }

    public boolean isVaiTrazerConvidado() { return vaiTrazerConvidado; }
    public void setVaiTrazerConvidado(boolean vaiTrazerConvidado) { this.vaiTrazerConvidado = vaiTrazerConvidado; }

    @Override
    public String toString() {
        return "🎓 Dados do Formando:\n" +
               "👤 Nome: " + nome + "\n" +
               "📚 Curso: " + curso + "\n" +
               "🏙️ Cidade: " + cidade + "\n" +
               "🎂 Idade: " + idade + "\n" +
               "🥤 Bebida Preferida: " + bebidaPreferida + "\n" +
               "🎵 Música Preferida: " + musicaPreferida + "\n" +
               "🍽️ Comida Preferida: " + comidaPreferida + "\n" +
               "👥 Vai trazer convidado: " + (vaiTrazerConvidado ? "Sim" : "Não");
    }
}