package com.alexepablo.dcc025.jogo.jogador;

import com.alexepablo.dcc025.jogo.personagem.Personagem;

public class JogadorIA extends Jogador {

    public JogadorIA(String nome, Personagem personagem) {
        super(nome, personagem);
    }
 
    @Override
    public void jogar() {
        System.out.println("jogando... " + this.getClass().getName());
    }
    
}
