package fag.lastWork.produto;

import fag.lastWork.alimento.Alimento;
import fag.lastWork.desconto.CalculoDesconto;
import fag.lastWork.produtoBase.ProdutoBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Produto extends ProdutoBase<Produto> implements CalculoDesconto {
    private String qualidadeEspecial;
    private static List<Produto> produtos = new ArrayList<>();

    public Produto(String nome, String preco, int quantidade, String qualidadeEspecial, boolean isVendavel) {
        super(nome, preco, quantidade, isVendavel);
        this.qualidadeEspecial = qualidadeEspecial;
    }

    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("=== Menu ===");
            System.out.println("1. Criar Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Listar Produtos");
            System.out.println("4. Sair");
            System.out.println("Escolha uma opção:");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarProduto();
                    break;
                case 2:
                    System.out.println("Digite o nome do produto a ser atualizado:");
                    String nome = scanner.nextLine();
                    Produto produto = encontrarProdutoPorNome(nome);
                    if (produto != null) {
                        produto.updateProduto();
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 3:
                    listarProdutos();
                    break;
                case 4 :
                    System.out.println("Digite o nome do produto a ser deletado:");
                    String nomeDeletar = scanner.nextLine();
                    Produto produtoDeletar = encontrarProdutoPorNome(nomeDeletar);
                    if (produtoDeletar != null) {
                        produtoDeletar.deletarProduto();
                    } else {
                        System.out.println("Produto não encontrado.");
                    }

                case 5: sair = true;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    break;
            }
        }
    }
    @Override
    public void deletarProduto() {
        produtos.remove(this);
        System.out.println("Livro deletado: " + getNome());
    }

    private static void criarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Criar Produto ===");
        System.out.println("Qual é o nome?");
        String nome = scanner.nextLine();

        System.out.println("Qual é o preço?");
        String preco = scanner.nextLine();

        System.out.println("Qual é a quantidade?");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual é a qualidade especial?");
        String qualidadeEspecial = scanner.nextLine();

        System.out.println("O produto é vendável? 1 - Sim, 2 - Não");
        int isVend = scanner.nextInt();
        scanner.nextLine();
        boolean isVendavel = isVend == 1;

        Produto produto = new Produto(nome, preco, quantidade, qualidadeEspecial, isVendavel);
        produtos.add(produto);

        System.out.println("Produto criado com sucesso");
    }

    private static Produto encontrarProdutoPorNome(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return produto;
            }
        }
        return null;
    }

    private static void listarProdutos() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Lista de Produtos ===");
        for (Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());

            System.out.println("Digite a porcentagem de desconto para " + produto.getNome() + ":");
            double desconto = scanner.nextDouble();

            double precoComDesconto = produto.calcularPrecoComDesconto(Double.parseDouble(produto.getPreco()), desconto);
            System.out.println("Preço com Desconto: " + precoComDesconto);
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("Qualidade Especial: " + produto.getQualidadeEspecial());
            System.out.println("Vendável: " + (produto.isVendavel() ? "Sim" : "Não"));
            System.out.println();
        }
    }


    public double calcularPrecoComDesconto(double preco, double desconto) {
        double valorDesconto = preco * desconto / 100;
        return preco - valorDesconto;
    }
    public String getQualidadeEspecial() {
        return qualidadeEspecial;
    }

    public void setQualidadeEspecial(String qualidadeEspecial) {
        this.qualidadeEspecial = qualidadeEspecial;
    }

    @Override
    protected Produto criarInstanciaProduto(String nome, String preco, int quantidade, Boolean isVendavel) {
        return new Produto(nome, preco, quantidade, qualidadeEspecial, isVendavel);
    }
}
