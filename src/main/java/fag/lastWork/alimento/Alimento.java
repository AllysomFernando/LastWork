package fag.lastWork.alimento;

import fag.lastWork.produtoBase.ProdutoBase;
import fag.lastWork.vendavel.Vendavel;

import java.util.Scanner;

public class Alimento extends ProdutoBase<Alimento> implements Vendavel {
    private String caloria;
    private boolean isVendavel;

    public boolean isVendavel() {
        return isVendavel;
    }

    public void setVendavel(boolean vendavel) {
        isVendavel = vendavel;
    }

    public static void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        Alimento alimento = null;

        while (!sair) {
            System.out.println("=== Menu ===");
            System.out.println("1. Criar Alimento");
            System.out.println("2. Atualizar Alimento");
            System.out.println("3. Sair");
            System.out.println("Escolha uma opção:");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    alimento = criarAlimentoPersonalizado();
                    System.out.println("Alimento criado:");
                    System.out.println("Nome: " + alimento.getNome());
                    System.out.println("Preço: " + alimento.getPreco());
                    System.out.println("Quantidade: " + alimento.getQuantidade());
                    System.out.println("Caloria: " + alimento.getCaloria());
                    System.out.println("Vendável: " + (alimento.isVendavel() ? "Sim" : "Não"));
                }
                case 2 -> {
                    if (alimento != null) {
                        updateProduto(alimento);
                    } else {
                        System.out.println("Nenhum alimento foi criado ainda.");
                    }
                }
                case 3 -> sair = true;
                default -> System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static Alimento criarAlimentoPersonalizado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Qual é o nome do alimento?");
        String nome = scanner.nextLine();

        System.out.println("Qual é o preço do alimento?");
        String preco = scanner.nextLine();

        System.out.println("Qual é a quantidade do alimento?");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Qual é a caloria do alimento?");
        String caloria = scanner.nextLine();

        System.out.println("O alimento é vendável? 1 - Sim, 2 - Não");
        int isVend = scanner.nextInt();
        boolean isVendavel;
        if (isVend == 1) {
            isVendavel = true;
        } else if (isVend == 2) {
            isVendavel = false;
        } else {
            System.out.println("Opção inválida. O alimento será considerado não vendável.");
            isVendavel = false;
        }

        Alimento alimento = new Alimento(nome, preco, quantidade, caloria);
        alimento.setVendavel(isVendavel);
        System.out.println("Alimento criado com sucesso");
        return alimento;
    }

    public Alimento(String nome, String preco, int quantidade, String caloria) {
        super(nome, preco, quantidade);
        this.caloria = caloria;
    }

    public static void updateProduto(Alimento alimento) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Atualizar Alimento ===");

        System.out.println("Qual é a nova caloria do Alimento?");
        String caloria = scanner.nextLine();
        alimento.setCaloria(caloria);

        System.out.println("O Alimento é vendável? 1 - Sim, 2 - Não");
        int isVend = scanner.nextInt();
        boolean isVendavel;
        if (isVend == 1) {
            isVendavel = true;
        } else if (isVend == 2) {
            isVendavel = false;
        } else {
            System.out.println("Opção inválida. O Alimento será considerado não vendável.");
            isVendavel = false;
        }

        alimento.setVendavel(isVendavel);
        System.out.println("Alimento atualizado com sucesso!");
        System.out.println();
    }

    @Override
    protected Alimento criarInstanciaProduto(String nome, String preco, int quantidade) {
        return new Alimento(nome, preco, quantidade, caloria);
    }

    public String getCaloria() {
        return caloria;
    }

    public void setCaloria(String caloria) {
        this.caloria = caloria;
    }
}
