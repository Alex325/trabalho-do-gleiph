package com.alexepablo.dcc025.jogo.personagem;

public class Arqueiro extends Personagem {
    public Arqueiro(int x, int y) {
        super(x, y, "Arqueiro", 'A', 5);
        this.ataque = 8;
        this.alcance = 5;
    }
    
    @Override
    public void habilidadeEspecial()
    {
        this.alcance++;
    }
}
