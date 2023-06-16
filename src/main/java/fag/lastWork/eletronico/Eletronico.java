package fag.lastWork.eletronico;
import fag.lastWork.alimento.Alimento;
import fag.lastWork.produtoBase.ProdutoBase;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Eletronico extends ProdutoBase <Eletronico> {
    static String voltagem;
    static List<Eletronico> eletronicos = new ArrayList<>();
    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

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
                case 1 -> criarEletronicoPersonalizado();
                case 2 -> {
                    System.out.println("Digite o nome do Eletronico a ser atualizado:");
                    String nome = scanner.nextLine();
                    Eletronico eletronico = encontrarEletronicoPorNome(nome);
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
                        eletronicoDeletar.deletarProduto();
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
    public void deletarProduto() {
        eletronicos.remove(this);
        System.out.println("Alimento deletado: " + getNome());
    }

    static void criarEletronicoPersonalizado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Criar Eletrônico ===");
        System.out.println("Qual é o nome?");
        String nome = scanner.nextLine();

        System.out.println("Qual é o preço?");
        String preco = scanner.nextLine();

        System.out.println("Qual é a quantidade?");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual é a voltagem do Eletronico?");
        String voltagem = scanner.nextLine();

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

        Eletronico eletronico = new Eletronico(nome, preco, quantidade, voltagem, isVendavel);
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
            System.out.println("Quantidade: " + eletronico.getQuantidade());
            System.out.println("Voltagem: " + eletronico.getVoltagem());
            System.out.println("Vendável: " + (eletronico.isVendavel() ? "Sim" : "Não"));
            System.out.println();
        }
    }
    public Eletronico(String nome, String preco, int quantidade, String voltagem, Boolean isVendavel) {
        super(nome, preco, quantidade, isVendavel);
        Eletronico.voltagem = voltagem;
        this.setVendavel(isVendavel);
    }

    @Override
    protected Eletronico criarInstanciaProduto(String nome, String preco, int quantidade, Boolean isVendavel) {
        return new Eletronico(nome, preco, quantidade, voltagem , isVendavel);

    }
    public String getVoltagem() {
        return voltagem;
    }

    public void setVoltagem(String voltagem) {
        Eletronico.voltagem = voltagem;
    }
}
