package fag.lastWork.alimento;

import fag.lastWork.produtoBase.ProdutoBase;

import java.util.Scanner;

public class Alimento extends ProdutoBase<Alimento> {
    private static String caloria;

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
                case 1 -> criarAlimentoPersonalizado();
                case 2 -> sair = true;
                default -> System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }
    private static void criarAlimentoPersonalizado() {
        Alimento alimento = new Alimento(nome, preco, quantidade, caloria);
        Scanner scanner = new Scanner(System.in);
        alimento.criarProduto();
        System.out.println("Qual é a caloria do Alimento?");
        System.out.println("Alimento criado com sucesso");
        String caloria = scanner.nextLine();
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


