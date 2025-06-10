package com.alexepablo.dcc025.jogo.personagem;

public class Guerreiro extends Personagem {

    private boolean habilidadeDisponivel;

    public Guerreiro(int x, int y) {
        super(x, y, "Guerreiro", 'G', 10);
        this.ataque = 15;
        this.alcance = 1;
        this.habilidadeDisponivel = true;
    }

    @Override
    public void habilidadeEspecial()
    {
        if(this.habilidadeDisponivel)
        {
           this.ataque *= 2;
           this.habilidadeDisponivel = false;
        }
    }
}
