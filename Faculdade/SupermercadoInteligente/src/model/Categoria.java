// ===== model/ =====
// Classe que representa uma categoria de produtos
package model;

public class Categoria {
    private String nome;
    private double totalVendas;

    // Construtor
    public Categoria(String nome) {
        this.nome = nome;
        this.totalVendas = 0.0;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    // Método para adicionar valor às vendas da categoria
    public void adicionarVenda(double valor) {
        this.totalVendas += valor;
    }

    @Override
    public String toString() {
        return String.format("%s - Total: R$ %.2f", nome, totalVendas);
    }
}