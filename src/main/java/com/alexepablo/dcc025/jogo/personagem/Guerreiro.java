package com.alexepablo.dcc025.jogo.personagem;

public class Guerreiro extends Personagem {

    public Guerreiro(int x, int y) {
        super(x, y, "Guerreiro", 'G', 10);
        this.ataque = 15;
        this.alcance = 1;
        this.habilidadeDisponivel = true;
    }

    @Override
    public void habilidadeEspecial(Personagem alvo)
    {
        this.ataque *= 2;
        this.habilidadeDisponivel = false;        
    }

}
