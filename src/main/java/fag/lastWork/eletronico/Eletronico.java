package fag.lastWork.eletronico;
import fag.lastWork.alimento.Alimento;
import fag.lastWork.produtoBase.ProdutoBase;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Eletronico extends ProdutoBase <Eletronico> {
    static String voltagem;
    static List<Eletronico> eletronicos = new ArrayList<>();

    public Eletronico() {
    }

    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        Eletronico eletronico = new Eletronico();
        while (!sair) {
            System.out.println("=== Menu ===");
            System.out.println("1. Criar Eletronico");
            System.out.println("2. Atualizar Eletronico");
            System.out.println("3. Listar Eletronico");
            System.out.println("4. Sair");
            System.out.println("Escolha uma opção:");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    assert eletronico != null;
                    eletronico.criarProdutoBase();
                }
                case 2 -> {
                    System.out.println("Digite o nome do Eletronico a ser atualizado:");
                    String nome = scanner.nextLine();
                    eletronico = encontrarEletronicoPorNome(nome);
                    if (eletronico != null) {
                        eletronico.updateProduto();
                    } else {
                        System.out.println("Eletronico não encontrado.");
                    }
                }
                case 3 -> listarEletronico();
                case 4 -> {
                    System.out.println("Digite o nome do alimento a ser deletado:");
                    String nomeDeletar = scanner.nextLine();
                    Eletronico eletronicoDeletar = encontrarEletronicoPorNome(nomeDeletar);
                    if (eletronicoDeletar != null) {
                        eletronicoDeletar.deletarProdutoBase();
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
        eletronicos.remove(this);
        System.out.println("Alimento deletado: " + getNome());
    }
    @Override
    public void criarProdutoBase() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Criar Eletrônico ===");
        System.out.println("Qual é o nome?");
        String nome = scanner.nextLine();

        System.out.println("Qual é o preço?");
        double preco = scanner.nextDouble();

        System.out.println("Qual é a quantidade?");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual é a voltagem do Eletronico?");
        String voltagem = scanner.nextLine();

        System.out.println("Qual é a porcentagem do desconto");
        double desconto = scanner.nextDouble();

        System.out.println("O Eletronico é vendável? 1 - Sim, 2 - Não");
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

        Eletronico eletronico = new Eletronico(nome, preco, quantidade, voltagem, isVendavel, desconto);
        eletronicos.add(eletronico);

        System.out.println("Eletronico criado com sucesso");
    }
    static Eletronico encontrarEletronicoPorNome(String nome) {
        for (Eletronico eletronico : eletronicos) {
            if (eletronico.getNome().equals(nome)) {
                return eletronico;
            }
        }
        return null;
    }
    static void listarEletronico() {
        System.out.println("=== Lista de Alimentos ===");
        for (Eletronico eletronico : eletronicos) {
            System.out.println("Nome: " + eletronico.getNome());
            System.out.println("Preço: " + eletronico.getPreco());
            System.out.println("Digite a porcentagem de desconto para " + eletronico.getDesconto() + ":");
            System.out.println("Preço com Desconto: " + eletronico.calcularPrecoComDesconto(eletronico.getPreco(), eletronico.getDesconto() ));
            System.out.println("Quantidade: " + eletronico.getQuantidade());
            System.out.println("Voltagem: " + eletronico.getVoltagem());
            System.out.println("Vendável: " + (eletronico.isVendavel() ? "Sim" : "Não"));
            System.out.println();
        }
    }
    public double calcularPrecoComDesconto(double preco, double desconto) {
        double valorDesconto = preco * desconto / 100;
        return preco - valorDesconto;
    }
    public Eletronico(String nome, double preco, int quantidade, String voltagem, Boolean isVendavel, double desconto) {
        super(nome, preco, quantidade, isVendavel, desconto);
        Eletronico.voltagem = voltagem;
        this.setVendavel(isVendavel);
    }

    @Override
    protected Eletronico criarInstanciaProduto(String nome, double preco, int quantidade, Boolean isVendavel, double desconto) {
        return new Eletronico(nome, preco, quantidade, voltagem , isVendavel, desconto);

    }
    public String getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(String voltagem) {
        Eletronico.voltagem = voltagem;
    }
}
