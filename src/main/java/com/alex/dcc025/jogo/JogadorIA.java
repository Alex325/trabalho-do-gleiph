package com.alex.dcc025.jogo;

public class JogadorIA extends Jogador {

    public JogadorIA(String nome) {
        super(nome);
    }
 
    @Override
    public void jogar() {
        System.out.println("jogando... " + this.getClass().getName());
    }
    
}
