package com.alexepablo.dcc025.jogo;

import com.alexepablo.dcc025.jogo.jogador.Jogador;
import com.alexepablo.dcc025.jogo.personagem.Personagem;

public class Tabuleiro {
    private char[] tabuleiro = new char[10*10];


    public Tabuleiro() {
        limparTabuleiro();
    }

    public void printTabuleiro() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tabuleiro[10*i + j] + " ");
            }

            System.out.print("\n");
        }
    }

    public void atualizarTabuleiro(Jogador[] jogadores) {
        limparTabuleiro();
        setPosicao(jogadores[0].getPersonagem().getAparencia(), jogadores[0].getPersonagem().getX(), jogadores[0].getPersonagem().getY());
        setPosicao(jogadores[1].getPersonagem().getAparencia(), jogadores[1].getPersonagem().getX(), jogadores[1].getPersonagem().getY());
    }

    public boolean validarAtaque(Personagem atacando, Personagem parado)
    {
        return atacando.getAlcance() >= distancia(atacando, parado);
         
    }

    public boolean movimentoValido(int x, int y) {
        return posicaoLivre(x, y) && dentroDoTabuleiro(x, y);
    }

    public boolean posicaoLivre(int x, int y) {
        return getPosicao(x, y) == '.';
    }

    public boolean dentroDoTabuleiro(int x, int y) {
        return x >= 0 && x <= 9 && y >= 0 && y <= 9;
    }

    public int distancia(Personagem p1, Personagem p2) {
        return Math.max(Math.abs(p1.getY() - p2.getY()), Math.abs(p1.getX() - p2.getX()));
    }

    private void limparTabuleiro() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {          
                setPosicao('.', x, y);
            }
        }
    }

    private char getPosicao(int x, int y) {
        return tabuleiro[10*y + x];
    }

    private void setPosicao(char valor, int x, int y) {
        tabuleiro[10*y + x] = valor;
    }

}
