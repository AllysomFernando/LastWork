package fag.lastWork.alimento;

import fag.lastWork.produtoBase.ProdutoBase;
import fag.lastWork.vendavel.Vendavel;

import java.util.Scanner;

public class Alimento extends ProdutoBase<Alimento> implements Vendavel {
    private static String caloria;
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

        while (!sair) {
            System.out.println("=== Menu ===");
            System.out.println("1. Criar Alimento");
            System.out.println("2. Sair");
            System.out.println("Escolha uma opção:");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    Alimento alimento = criarAlimentoPersonalizado();
                    System.out.println("Alimento criado:");
                    System.out.println("Nome: " + alimento.getNome());
                    System.out.println("Preço: " + alimento.getPreco());
                    System.out.println("Quantidade: " + alimento.getQuantidade());
                    System.out.println("Caloria: " + alimento.getCaloria());
                    System.out.println("Vendável: " + (alimento.isVendavel() ? "Sim" : "Não"));
                }
                case 2 -> sair = true;
                default -> System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }
    private static Alimento criarAlimentoPersonalizado() {
        Alimento alimento = new Alimento(nome, preco, quantidade, caloria);
        Scanner scanner = new Scanner(System.in);
        alimento.criarProduto();
        System.out.println("Qual é a caloria do Alimento?");
        String caloria = scanner.nextLine();
        alimento.setCaloria(caloria);
        System.out.println("O alimento é vendivel? 1 - Sim, 2 - Não");
        int isVend = scanner.nextInt();
        if(isVend == 1){
            alimento.setVendavel(true);
        }else if(isVend == 2){
            alimento.setVendavel(false);
        }else {
            System.out.println("Opção inválida. O alimento será considerado não vendável.");
            alimento.setVendavel(false);
        }
        System.out.println("Alimento criado com sucesso");
        return alimento;
    }


    public Alimento(String nome, String preco, int quantidade, String caloria) {
        super(nome, preco, quantidade);
        Alimento.caloria = caloria;
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


