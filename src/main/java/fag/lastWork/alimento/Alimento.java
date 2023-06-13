package fag.lastWork.alimento;

import fag.lastWork.produtoBase.ProdutoBase;

public class Alimento {
    private String preco;
    private String nome;

    private Integer quantidade;

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}
