package model;
public class Sanduiche {
    private String pao;
    private String proteina;
    private String queijo;
    private String salada;
    private String molho;
    private double preco;

    public Sanduiche() {
        this.pao = "";
        this.proteina = "";
        this.queijo = "";
        this.salada = "";
        this.molho = "";
        this.preco = 0.0;
    }

    // Getters e Setters
    public String getPao() { return pao; }
    public void setPao(String pao) { this.pao = pao; }

    public String getProteina() { return proteina; }
    public void setProteina(String proteina) { this.proteina = proteina; }

    public String getQueijo() { return queijo; }
    public void setQueijo(String queijo) { this.queijo = queijo; }

    public String getSalada() { return salada; }
    public void setSalada(String salada) { this.salada = salada; }

    public String getMolho() { return molho; }
    public void setMolho(String molho) { this.molho = molho; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    @Override
    public String toString() {
        return "Sanduíche:\n" +
               "Pão: " + pao + "\n" +
               "Proteína: " + proteina + "\n" +
               "Queijo: " + queijo + "\n" +
               "Salada: " + salada + "\n" +
               "Molho: " + molho + "\n" +
               "Preço: R$ " + String.format("%.2f", preco);
    }
}