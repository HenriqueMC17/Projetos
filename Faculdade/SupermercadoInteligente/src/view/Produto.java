// ===== model/ =====
// Classe que representa um produto no sistema
package view;

public class Produto {
    private String nome;
    private double preco;
    private String categoria;

    // Construtor
    public Produto(String nome, double preco, String categoria) {
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Método para aplicar desconto
    public void aplicarDesconto(double percentual) {
        this.preco = this.preco * (1 - percentual/100);
    }

    // Método para aplicar reajuste
    public void aplicarReajuste(double percentual) {
        this.preco = this.preco * (1 + percentual/100);
    }

    @Override
    public String toString() {
        return String.format("%s - R$ %.2f (%s)", nome, preco, categoria);
    }
}