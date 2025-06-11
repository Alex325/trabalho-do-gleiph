package com.alexepablo.dcc025.jogo.jogador;

import com.alexepablo.dcc025.jogo.personagem.Personagem;

public class JogadorIA extends Jogador {

    public JogadorIA(String nome, Personagem personagem, String tipo) {
        super(nome, personagem, tipo);
    }
 
    @Override
    public boolean jogar(Jogador outro, int turno) {
        System.out.println("jogando... " + this.getClass().getName());
        return false;
    }
    
}
