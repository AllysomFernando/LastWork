package fag.lastWork.produtoBase;


import fag.lastWork.vendavel.Vendavel;

import java.util.Scanner;

public abstract class ProdutoBase<T> implements Vendavel  {
    public String nome;
    public double preco;
    public int quantidade;
    private boolean isVendavel;


    public double desconto;

    public ProdutoBase() {
    }


    public boolean isVendavel() {
        return isVendavel;
    }

    public void setVendavel(boolean vendavel) {
        isVendavel = vendavel;
    }

    public ProdutoBase(String nome, double preco, int quantidade, Boolean isVendavel, double desconto) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.desconto = desconto;
        this.isVendavel = isVendavel;
    }

    public abstract void deletarProdutoBase();


    public abstract void criarProdutoBase();


    public void updateProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Atualizar Produto ===");
        System.out.println("Qual é o novo nome do Produto?");
        nome = scanner.nextLine();

        System.out.println("Qual é o novo preço do Produto?");
        preco = scanner.nextDouble();

        System.out.println("Qual é a nova quantidade do Produto?");
        quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual é a porcentagem do desconto");
        desconto = scanner.nextDouble();

        System.out.println("Produto atualizado com sucesso!");
        System.out.println();
    }

    protected abstract T criarInstanciaProduto(String nome, double preco, int quantidade, Boolean isVendavel, double desconto);

    public String getNome() {
        return nome;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
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

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
