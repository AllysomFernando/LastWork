package fag.lastWork.livro.enums;

public enum Editora {
    PENGUIN_RANDOM_HOUSE ("Penguin Random House"),
    HARPERCOLLINS ("HarperCollins"),
    SIMON_AND_SCHUSTER ("Simon and Suchster"),
    HACHETTE_LIVRE ("Hachette Livre"),
    MACMILLAN_PUBLISHERS ("Macmillan Publishers"),
    WILEY ("Wiley"),
    SCHOLASTIC_CORPORATION ("Scholastic Corporation"),
    PEARSON_EDUCATION ("Pearson Education"),
    ELSEVIER ("Elsevier"),
    OREILLY_MEDIA ("Oreilly Media"),
    CAMBRIDGE_UNIVERSITY_PRESS ("Cambridge University Press"),
    OXFORD_UNIVERSITY_PRESS ("Oxford University Press"),
    BLOOMSBURY_PUBLISHING("Bloombury Publishing"),
    GRUPO_PLANETA ("Grupo Planeta"),
    GRUPO_SANTILLANA ("Grupo Santillana"),
    GRUPO_ANAYA("Grupo Anaya"),
    GRUPO_SM("Grupo SM"),
    GRUPO_EDITORIAL_NORMA("Grupo Editorial Norma"),
    GRUPO_RBA ("Grupo RBA"),
    GRUPO_PENGUIN("Grupo Penguin");

    private String nomesEditoras;

    Editora(String nomesEditoras){
        this.nomesEditoras = nomesEditoras;
    }

    public String getNomesEditoras() {
        return nomesEditoras;
    }

    public void setNomesEditoras(String nomesEditoras) {
        this.nomesEditoras = nomesEditoras;
    }



}
