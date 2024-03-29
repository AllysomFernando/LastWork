package fag.lastWork.alimento;

import fag.lastWork.desconto.CalculoDesconto;
import fag.lastWork.produtoBase.ProdutoBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alimento extends ProdutoBase<Alimento> implements CalculoDesconto{
    private String caloria;
    static List<Alimento> alimentos = new ArrayList<>();

    public Alimento() {

    }

    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        Alimento alimento = new Alimento();
        while (!sair) {
            System.out.println("=== Menu ===");
            System.out.println("1. Criar Alimento");
            System.out.println("2. Atualizar Alimento");
            System.out.println("3. Listar Alimentos");
            System.out.println("4. Deletar alimentos");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opção:");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    assert alimento != null;
                    alimento.criarProdutoBase();
                }
                case 2 -> {
                    System.out.println("Digite o nome do alimento a ser atualizado:");
                    String nome = scanner.nextLine();
                     alimento = encontrarAlimentoPorNome(nome);
                    if (alimento != null) {
                        alimento.updateProduto();
                    } else {
                        System.out.println("Alimento não encontrado.");
                    }
                }
                case 3 -> listarAlimentos();
                case 4 -> {
                    System.out.println("Digite o nome do alimento a ser deletado:");
                    String nomeDeletar = scanner.nextLine();
                    Alimento alimentoDeletar = encontrarAlimentoPorNome(nomeDeletar);
                    if (alimentoDeletar != null) {
                        alimentoDeletar.deletarProdutoBase();
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                }
                case 5 -> sair = true;
                default -> System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }
    @Override
    public void deletarProdutoBase() {
        alimentos.remove(this);
        System.out.println("Alimento deletado: " + getNome());
    }
        @Override
        public void criarProdutoBase() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Criar Alimento ===");
        System.out.println("Qual é o nome?");
        String nome = scanner.nextLine();

        System.out.println("Qual é o preço?");
        double preco = scanner.nextDouble();

        System.out.println("Qual é a quantidade?");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual é a caloria do Alimento?");
        String caloria = scanner.nextLine();

        System.out.println("Qual é a porcentagem do desconto");
        double desconto = scanner.nextDouble();

        System.out.println("O alimento é vendável? 1 - Sim, 2 - Não");
        int isVend = scanner.nextInt();
        scanner.nextLine();

        boolean isVendavel;
        if (isVend == 1) {
            isVendavel = true;
        } else if (isVend == 2) {
            isVendavel = false;
        } else {
            System.out.println("Opção inválida. O alimento será considerado não vendável.");
            isVendavel = false;
        }

        Alimento alimento = new Alimento(nome, preco, quantidade, caloria, isVendavel,desconto);
        alimentos.add(alimento);

        System.out.println("Alimento criado com sucesso");
    }

     static Alimento encontrarAlimentoPorNome(String nome) {
        for (Alimento alimento : alimentos) {
            if (alimento.getNome().equals(nome)) {
                return alimento;
            }
        }
        return null;
    }

    static void listarAlimentos() {
        System.out.println("=== Lista de Alimentos ===");
        for (Alimento alimento : alimentos) {
            System.out.println("Nome: " + alimento.getNome());
            System.out.println("Preço: " + alimento.getPreco());
            System.out.println("Digite a porcentagem de desconto para " + alimento.getDesconto() + ":");
            System.out.println("Preço com Desconto: " + alimento.calcularPrecoComDesconto(alimento.getPreco(), alimento.getDesconto() ));
            System.out.println("Quantidade: " + alimento.getQuantidade());
            System.out.println("Caloria: " + alimento.getCaloria());
            System.out.println("Vendável: " + (alimento.isVendavel() ? "Sim" : "Não"));
            System.out.println();
        }
    }

    public Alimento(String nome, double preco, int quantidade, String caloria, boolean isVendavel, double desconto) {
        super(nome, preco, quantidade, isVendavel, desconto);
        this.caloria = caloria;
        this.setVendavel(isVendavel);
    }
    public double calcularPrecoComDesconto(double preco, double desconto) {
        double valorDesconto = preco * desconto / 100;
        return preco - valorDesconto;
    }

        @Override
        protected Alimento criarInstanciaProduto(String nome, double preco, int quantidade, Boolean isVendavel, double desconto) {
            return new Alimento(nome, preco, quantidade, caloria, isVendavel, desconto);
        }

    public String getCaloria() {
        return caloria;
    }

    public void setCaloria(String caloria) {
        this.caloria = caloria;
    }
}
