package com.alex.dcc025.jogo;

public class JogadorHumano extends Jogador {

    public JogadorHumano(String nome) {
        super(nome);
    }

    @Override
    public void jogar() {
        System.out.println("jogando... " + this.getClass().getName());
    }

    
    
}
