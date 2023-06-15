package fag.lastWork.alimento;

import fag.lastWork.produtoBase.ProdutoBase;
import fag.lastWork.vendavel.Vendavel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alimento extends ProdutoBase<Alimento> implements Vendavel {
    private String caloria;
    private boolean isVendavel;
     static List<Alimento> alimentos = new ArrayList<>();

    public boolean isVendavel() {
        return isVendavel;
    }

    public void setVendavel(boolean vendavel) {
        isVendavel = vendavel;
    }

    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("=== Menu ===");
            System.out.println("1. Criar Alimento");
            System.out.println("2. Atualizar Alimento");
            System.out.println("3. Listar Alimentos");
            System.out.println("4. Sair");
            System.out.println("Escolha uma opção:");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarAlimentoPersonalizado();
                    break;
                case 2:
                    System.out.println("Digite o nome do alimento a ser atualizado:");
                    String nome = scanner.nextLine();
                    Alimento alimento = encontrarAlimentoPorNome(nome);
                    if (alimento != null) {
                        alimento.updateProduto();
                    } else {
                        System.out.println("Alimento não encontrado.");
                    }
                    break;
                case 3:
                    listarAlimentos();
                    break;
                case 4:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                    break;
            }
        }
    }

        static void criarAlimentoPersonalizado() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Criar Alimento ===");
        System.out.println("Qual é o nome?");
        String nome = scanner.nextLine();

        System.out.println("Qual é o preço?");
        String preco = scanner.nextLine();

        System.out.println("Qual é a quantidade?");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual é a caloria do Alimento?");
        String caloria = scanner.nextLine();

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

        Alimento alimento = new Alimento(nome, preco, quantidade, caloria, isVendavel);
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
            System.out.println("Quantidade: " + alimento.getQuantidade());
            System.out.println("Caloria: " + alimento.getCaloria());
            System.out.println("Vendável: " + (alimento.isVendavel() ? "Sim" : "Não"));
            System.out.println();
        }
    }

    public Alimento(String nome, String preco, int quantidade, String caloria, boolean isVendavel) {
        super(nome, preco, quantidade);
        this.caloria = caloria;
        this.isVendavel = isVendavel;
    }

    @Override
    protected Alimento criarInstanciaProduto(String nome, String preco, int quantidade) {
        return new Alimento(nome, preco, quantidade, caloria, isVendavel);
    }

    public String getCaloria() {
        return caloria;
    }

    public void setCaloria(String caloria) {
        this.caloria = caloria;
    }
}
