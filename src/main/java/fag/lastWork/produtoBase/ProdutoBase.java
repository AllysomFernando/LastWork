package fag.lastWork.produtoBase;
import java.util.Scanner;

public abstract class ProdutoBase<T> {
    public static String nome;
    public static String preco;
    public static int quantidade;

    public ProdutoBase(String nome, String preco, int quantidade) {
        ProdutoBase.nome = nome;
        ProdutoBase.preco = preco;
        ProdutoBase.quantidade = quantidade;
    }

    public void criarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Criar Produto ===");
        System.out.println("Qual é o nome?");
        String nome = scanner.nextLine();

        System.out.println("Qual é o preço?");
        String preco = scanner.nextLine();

        System.out.println("Qual é a quantidade?");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        T produto = criarInstanciaProduto(nome, preco, quantidade);

        System.out.println("Produto criado com sucesso!");
        System.out.println();
    }

    protected abstract T criarInstanciaProduto(String nome, String preco, int quantidade);
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        ProdutoBase.nome = nome;
    }
    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        ProdutoBase.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        ProdutoBase.quantidade = quantidade;
    }
}
