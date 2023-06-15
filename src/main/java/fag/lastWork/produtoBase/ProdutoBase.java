package fag.lastWork.produtoBase;

import java.util.Scanner;

public abstract class ProdutoBase<T> {
    public String nome;
    public String preco;
    public int quantidade;

    public ProdutoBase(String nome, String preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public void criarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Criar Produto ===");
        System.out.println("Qual é o nome?");
        nome = scanner.nextLine();

        System.out.println("Qual é o preço?");
        preco = scanner.nextLine();

        System.out.println("Qual é a quantidade?");
        quantidade = scanner.nextInt();
        scanner.nextLine();

        T produto = criarInstanciaProduto(nome, preco, quantidade);
        System.out.println();
    }

    public void updateProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Atualizar Produto ===");
        System.out.println("Qual é o novo nome do Produto?");
        nome = scanner.nextLine();

        System.out.println("Qual é o novo preço do Produto?");
        preco = scanner.nextLine();

        System.out.println("Qual é a nova quantidade do Produto?");
        quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Produto atualizado com sucesso!");
        System.out.println();
    }

    protected abstract T criarInstanciaProduto(String nome, String preco, int quantidade);

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
