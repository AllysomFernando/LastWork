package fag.lastWork;


import fag.lastWork.alimento.Alimento;
import fag.lastWork.eletronico.Eletronico;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean sair = false;

        while (!sair) {
            System.out.println("=== Menu ===");
            System.out.println("1. Alimentos");
            System.out.println("2. Eletrônico");
            System.out.println("3. Sair");
            System.out.println("Escolha uma opção:");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> Alimento.exibirMenu();
                case 2 -> Eletronico.exibirMenu();
                case 3 -> sair = true;
                default -> System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }
}
