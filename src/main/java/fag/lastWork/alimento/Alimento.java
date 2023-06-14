package fag.lastWork.alimento;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alimento {
    static Scanner scanner = new Scanner(System.in);
    static List<Alimento> alimentos = new ArrayList<>();
    String nome;
    String preco;
    Integer quantidade;
    public static void alimento() {
        boolean executando = true;
        while (executando) {
            System.out.println("=== Menu ===");
            System.out.println("1. Criar alimento");
            System.out.println("2. Listar alimentos");
            System.out.println("3. Atualizar alimento");
            System.out.println("4. Excluir alimento");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarAlimento();
                    break;
                case 2:
                    listarAlimentos();
                    break;
                case 3:
                    atualizarAlimento();
                    break;
                case 4:
                    excluirAlimento();
                    break;
                case 5:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    public static void criarAlimento() {
        Alimento alimento = new Alimento();

        System.out.println("=== Criar Alimento ===");
        System.out.println("Qual é o nome do alimento?");
        String nome = scanner.nextLine();
        alimento.setNome(nome);

        System.out.println("Qual é o preço do alimento?");
        String preco = scanner.nextLine();
        alimento.setPreco(preco);

        System.out.println("Qual é a quantidade do alimento?");
        int quantidade = scanner.nextInt();
        alimento.setQuantidade(quantidade);

        alimentos.add(alimento);
        System.out.println("Alimento criado com sucesso!");
        System.out.println();
    }

    public static void listarAlimentos() {
        if (alimentos.isEmpty()) {
            System.out.println("Não há alimentos cadastrados.");
        } else {
            System.out.println("=== Lista de Alimentos ===");
            for (Alimento alimento : alimentos) {
                System.out.println("Nome: " + alimento.getNome());
                System.out.println("Preço: " + alimento.getPreco());
                System.out.println("Quantidade: " + alimento.getQuantidade());
                System.out.println("----------------------");
            }
        }
        System.out.println();
    }

    public static void atualizarAlimento() {
        if (alimentos.isEmpty()) {
            System.out.println("Não há alimentos cadastrados.");
        } else {
            System.out.println("=== Atualizar Alimento ===");
            System.out.print("Digite o nome do alimento que deseja atualizar: ");
            String nome = scanner.nextLine();

            Alimento alimentoEncontrado = null;
            for (Alimento alimento : alimentos) {
                if (alimento.getNome().equalsIgnoreCase(nome)) {
                    alimentoEncontrado = alimento;
                    break;
                }
            }

            if (alimentoEncontrado != null) {
                System.out.println("Qual é o novo nome do alimento?");
                String novoNome = scanner.nextLine();
                alimentoEncontrado.setNome(novoNome);

                System.out.println("Qual é o novo preço do alimento?");
                String novoPreco = scanner.nextLine();
                alimentoEncontrado.setPreco(novoPreco);

                System.out.println("Qual é a nova quantidade do alimento?");
                int novaQuantidade = scanner.nextInt();
                alimentoEncontrado.setQuantidade(novaQuantidade);

                System.out.println("Alimento atualizado com sucesso!");
            } else {
                System.out.println("Alimento não encontrado.");
            }
        }
        System.out.println();
    }

    public static void excluirAlimento() {
        if (alimentos.isEmpty()) {
            System.out.println("Não há alimentos cadastrados.");
        } else {
            System.out.println("=== Excluir Alimento ===");
            System.out.print("Digite o nome do alimento que deseja excluir: ");
            String nome = scanner.nextLine();

            Alimento alimentoEncontrado = null;
            for (Alimento alimento : alimentos) {
                if (alimento.getNome().equalsIgnoreCase(nome)) {
                    alimentoEncontrado = alimento;
                    break;
                }
            }

            if (alimentoEncontrado != null) {
                alimentos.remove(alimentoEncontrado);
                System.out.println("Alimento excluído com sucesso!");
            } else {
                System.out.println("Alimento não encontrado.");
            }
        }
        System.out.println();
    }
    public String getPreco() {;
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

}


