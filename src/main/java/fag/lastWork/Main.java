package fag.lastWork;


import fag.lastWork.alimento.Alimento;
import fag.lastWork.eletronico.Eletronico;
import fag.lastWork.livro.Livro;
import fag.lastWork.produto.Produto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;

        while (!sair) {
            System.out.println("=== Menu ===");
            System.out.println("1. Alimentos");
            System.out.println("2. Eletrônico");
            System.out.println("3. Livros");
            System.out.println("4. Produto");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opção:");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> Alimento.exibirMenu();
                case 2 -> Eletronico.exibirMenu();
                case 3 -> Livro.exibirMenu();
                case 4 -> Produto.exibirMenu();
                case 5 -> sair = true;
                default -> System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }
}
