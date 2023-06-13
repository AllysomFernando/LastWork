package fag.lastWork.alimento.alimentoController;

import java.util.Scanner;
import fag.lastWork.alimento.Alimento;

public class AlimentoController {
    public static void alimentoController(){

        Scanner scanner = new Scanner(System.in);
        String nome;
        int preco;
        int quantidade;
        System.out.println("Qual é o nome do seu alimento");
        nome = scanner.nextLine();
        System.out.println("Qual é o preço do seu alimento");
        preco = scanner.nextInt();
        System.out.println("Qual é a quantidade do seu alimento");
        quantidade = scanner.nextInt();
    }
}
