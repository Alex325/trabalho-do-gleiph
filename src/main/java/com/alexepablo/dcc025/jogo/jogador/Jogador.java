package com.alexepablo.dcc025.jogo.jogador;

import com.alexepablo.dcc025.jogo.personagem.Personagem;

public class Jogador {

    protected final String nome;
    protected final Personagem personagem;

    public Jogador(String nome, Personagem personagem) {
        this.nome = nome;
        this.personagem = personagem;
    }

    public void jogar() {
        // intencionalmente vazio
    }

    public String nomeCompleto() {
        return this.personagem.getClasse() + " " + nome;
    }
    
    public Personagem getPersonagem() {
        return this.personagem;
    }
}
