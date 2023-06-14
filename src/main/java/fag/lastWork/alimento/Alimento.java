package fag.lastWork.alimento;

import java.util.Scanner;

public class Alimento {
    Scanner scanner = new Scanner(System.in);
    private String preco;
    private String nome;
    private Integer quantidade;


    public Alimento(String preco, String nome, Integer quantidade){
        this.preco = preco;
        this.nome = nome;
        this.quantidade = quantidade;
    }
    public void lerNome(){
        System.out.println("Qual é o nome do seu alimento?");
        String nome = scanner.nextLine();
        setNome(nome);
    }
    public void lerPreco(){
        System.out.println("Qual é o preço do seu alimento?");
        String preco = scanner.nextLine();
        setPreco(preco);
    }

    public void lerQuantidade(){
        System.out.println("Qual é a quantidade do seu alimento?");
        String preco = scanner.nextLine();
        setPreco(preco);
    }

    public static void gerarAlimento(){
        Alimento alimento = new Alimento(null,null,null);
        alimento.lerPreco();
        alimento.lerNome();
        alimento.lerQuantidade();
    }


    public static void updateAlimento(){
        System.out.println("Qual é o alimento que você quer deletar?");
        gerarAlimento();
    }

    public String getPreco() {
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
