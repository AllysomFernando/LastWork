package fag.lastWork.livro;

import fag.lastWork.desconto.CalculoDesconto;
import fag.lastWork.produtoBase.ProdutoBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Livro extends ProdutoBase<Livro> implements CalculoDesconto {
    private String autor;
    private List<String> genero;
    private List<String> editora;
    private int disponibilidade;
    private static List<Livro> livros = new ArrayList<>();

    public Livro(String nome, double preco, int quantidade, String autor, List<String> genero, List<String> editora, int disponibilidade, boolean isVendavel, double desconto) {
        super(nome, preco, quantidade, isVendavel, desconto);
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
        this.setVendavel(isVendavel);
        this.disponibilidade = disponibilidade;
    }

    public Livro() {

    }

    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        Livro livro = new Livro();
        while (!sair) {
            System.out.println("=== Menu ===");
            System.out.println("1. Criar Livro");
            System.out.println("2. Atualizar Livro");
            System.out.println("3. Listar Livros");
            System.out.println("4. Sair");
            System.out.println("Escolha uma opção:");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    assert livro != null;
                    livro.criarProdutoBase();
                }
                case 2 -> {
                    System.out.println("Digite o nome do livro a ser atualizado:");
                    String nome = scanner.nextLine();
                     livro = encontrarLivroPorNome(nome);
                    if (livro != null) {
                        livro.updateProduto();
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                }
                case 3 -> listarLivros();
                case 4 -> {
                    System.out.println("Digite o nome do produto a ser deletado:");
                    String nomeDeletar = scanner.nextLine();
                    Livro livroDeletar = encontrarLivroPorNome(nomeDeletar);
                    if (livroDeletar != null) {
                        livroDeletar.deletarProdutoBase();
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                }
                case 5 -> sair = true;
                default -> System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    public double calcularPrecoComDesconto(double preco, double desconto) {
        double valorDesconto = preco * desconto / 100;
        return preco - valorDesconto;
    }
    @Override
    public void criarProdutoBase() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Criar Livro ===");
        System.out.println("Qual é o nome?");
        String nome = scanner.nextLine();

        System.out.println("Qual é o preço?");
        double preco = scanner.nextDouble();

        System.out.println("Qual é a quantidade?");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual é o autor?");
        String autor = scanner.nextLine();

        System.out.println("Qual é a porcentagem do desconto");
        double desconto = scanner.nextDouble();

        System.out.println("Quantos gêneros o livro possui?");
        int numGeneros = scanner.nextInt();
        scanner.nextLine();
        List<String> genero = new ArrayList<>();
        for (int i = 0; i < numGeneros; i++) {
            System.out.println("Gênero " + (i + 1) + ":");
            genero.add(scanner.nextLine());
        }

        System.out.println("Quantas editoras o livro possui?");
        int numEditoras = scanner.nextInt();
        scanner.nextLine();
        List<String> editora = new ArrayList<>();
        for (int i = 0; i < numEditoras; i++) {
            System.out.println("Editora " + (i + 1) + ":");
            editora.add(scanner.nextLine());
        }

        System.out.println("Qual é a disponibilidade?");
        int disponibilidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("O livro é vendável? 1 - Sim, 2 - Não");
        int isVend = scanner.nextInt();
        scanner.nextLine();
        boolean isVendavel = isVend == 1;

        Livro livro = new Livro(nome, preco, quantidade, autor, genero, editora, disponibilidade, isVendavel, desconto);
        livros.add(livro);

        System.out.println("Livro criado com sucesso");
    }

    private static Livro encontrarLivroPorNome(String nome) {
        for (Livro livro : livros) {
            if (livro.getNome().equals(nome)) {
                return livro;
            }
        }
        return null;
    }

    @Override
    public void deletarProdutoBase() {
        livros.remove(this);
        System.out.println("Livro deletado: " + getNome());
    }

    private static void listarLivros() {
        System.out.println("=== Lista de Livros ===");
        for (Livro livro : livros) {
            System.out.println("Nome: " + livro.getNome());
            System.out.println("Preço: " + livro.getPreco());
            double precoComDesconto = livro.calcularPrecoComDesconto(livro.getPreco(), livro.getDesconto());
            System.out.println("Preço com Desconto: " + precoComDesconto);
            System.out.println("Quantidade: " + livro.getQuantidade());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Gênero(s): " + livro.getGenero());
            System.out.println("Editora(s): " + livro.getEditora());
            System.out.println("Disponibilidade: " + livro.getDisponibilidade());
            System.out.println("Vendável: " + (livro.isVendavel() ? "Sim" : "Não"));
            System.out.println();
        }
    }
    @Override
    protected Livro criarInstanciaProduto(String nome, double preco, int quantidade, Boolean isVendavel, double desconto) {
        return new Livro(nome, preco, quantidade, autor, genero, editora, disponibilidade, isVendavel, desconto);
    }
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public List<String> getGenero() {
        return genero;
    }

    public void setGenero(List<String> genero) {
        this.genero = genero;
    }

    public List<String> getEditora() {
        return editora;
    }

    public void setEditora(List<String> editora) {
        this.editora = editora;
    }

    public int getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(int disponibilidade) {
        this.disponibilidade = disponibilidade;
    }



}
