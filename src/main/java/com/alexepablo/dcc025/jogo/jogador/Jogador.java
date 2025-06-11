package com.alexepablo.dcc025.jogo.jogador;

import com.alexepablo.dcc025.jogo.Tabuleiro;
import com.alexepablo.dcc025.jogo.personagem.Personagem;

public class Jogador {

    protected final String nome;
    protected final Personagem personagem;
    protected final String tipo;

    public Jogador(String nome, Personagem personagem, String tipo) {
        this.nome = nome;
        this.personagem = personagem;
        this.tipo = tipo;
    }

    public boolean jogar(Jogador outro, int turno) {
        return false;
    }
    
    public String nomeCompleto() {
        return this.personagem.getClasse() + " " + nome;
    }
    
    public Personagem getPersonagem() {
        return this.personagem;
    }

    public String getTipo() {
        return this.tipo;
    }
    
    public void printStatus() {
        System.out.println(String.format("Jogador %s | Posição (%d, %d)", this.tipo, this.personagem.getX(), this.personagem.getY()));
        System.out.println(String.format("%s | PV: %d/100 | Defesa: %d/%d | Ataque: %d | Alcance: %d", nomeCompleto(), this.personagem.getVida(), this.personagem.getDefesa(), this.personagem.getDefesaInicial(), this.personagem.getAtaque(), this.personagem.getAlcance()));
    }

    protected boolean habilidadeEspecial(Personagem alvo) {
        if (!this.personagem.habilidadeDisponivel()) return false;

        this.personagem.habilidadeEspecial(alvo);

        return true;
    }

    protected void defender() {
        this.personagem.defender();
    }

    protected boolean atacar(Jogador outro) {
        if (!Tabuleiro.tabuleiro().ataqueValido(this.personagem, outro.getPersonagem())) return false;
            
        this.personagem.atacar(outro.getPersonagem());
        return true;
    }
}
