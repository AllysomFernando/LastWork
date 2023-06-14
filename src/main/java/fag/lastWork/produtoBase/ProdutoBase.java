package fag.lastWork.produtoBase;

import fag.lastWork.alimento.Alimento;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class ProdutoBase {

    static List<ProdutoBase> produtos = new ArrayList<>();

    public static void criarProgramar() {
        Scanner scanner = new Scanner(System.in);
        Alimento alimento = new Alimento();

        System.out.println("=== Criar Produto ===");
        System.out.println("Qual é o nome do Produto?");
        String nome = scanner.nextLine();

        System.out.println("Qual é o preço do Produto?");
        String preco = scanner.nextLine();


        System.out.println("Qual é a quantidade do Produto?");
        int quantidade = scanner.nextInt();
        alimento.setQuantidade(quantidade);

        alimentos.add(alimento);
        System.out.println("Alimento criado com sucesso!");
        System.out.println();
    }
}
