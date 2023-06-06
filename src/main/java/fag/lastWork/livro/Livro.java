package fag.lastWork.livro;

import fag.lastWork.produtoBase.ProdutoBase;

public class Livro extends ProdutoBase {
    private String nome;
    private String autor;
    private String preço;
    private Enum genero; //criado um enum importar dps
    private Enum editora; //criado um enum importar dps
    private int disponibilidade;
}
