package com.alexepablo.dcc025.jogo.jogador;

import com.alexepablo.dcc025.jogo.personagem.Personagem;

public class JogadorHumano extends Jogador {

    public JogadorHumano(String nome, Personagem personagem) {
        super(nome, personagem);
    }

    @Override
    public void jogar() {
        System.out.println("jogando... " + this.getClass().getName());
    }

    
    
}
