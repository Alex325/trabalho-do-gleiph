package com.alex.dcc025.jogo.personagem;

public class Personagem {
    private int x, y;
    private final String classe;
    private final char aparencia;

    public Personagem(int x, int y, String classe, char aparencia) {
        this.x = x;
        this.y = y;
        this.classe = classe;
        this.aparencia = aparencia;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getClasse() {
        return classe;
    }

    public char getAparencia() {
        return aparencia;
    }

}
