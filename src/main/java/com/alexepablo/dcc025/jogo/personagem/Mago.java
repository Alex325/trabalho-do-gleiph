package com.alexepablo.dcc025.jogo.personagem;

public class Mago extends Personagem {
    public Mago(int x, int y) {
        super(x, y, "Mago", 'M', 5);
        this.ataque = 10;
        this.alcance = 3;
    }

    @Override
    public void habilidadeEspecial(Personagem alvo)
    {
        int troca = this.vida;
        this.vida = alvo.getVida();
        alvo.setVida(troca);
    }

}
