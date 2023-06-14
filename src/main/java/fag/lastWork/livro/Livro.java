package fag.lastWork.livro;

import fag.lastWork.produtoBase.ProdutoBase;

import java.util.List;

public class Livro extends ProdutoBase {
    private String autor;

    private List genero; //criado um enum importar dps
    private List editora; //criado um enum importar dps
    private int disponibilidade;
}
