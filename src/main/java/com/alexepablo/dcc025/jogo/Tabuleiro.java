package com.alexepablo.dcc025.jogo;

import com.alexepablo.dcc025.jogo.jogador.Jogador;
import com.alexepablo.dcc025.jogo.personagem.Personagem;

public class Tabuleiro {
    private char[] matrizTabuleiro = new char[10*10];

    private static Tabuleiro tabuleiro;

    public static Tabuleiro tabuleiro() {
        if (tabuleiro != null) return tabuleiro;
        tabuleiro = new Tabuleiro();
        return tabuleiro;
    }

    public void printTabuleiro() {

        System.out.println("  0 1 2 3 4 5 6 7 8 9");

        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");

            for (int j = 0; j < 10; j++) {
                System.out.print(matrizTabuleiro[10*i + j] + " ");
            }

            System.out.print("\n");
        }
    }

    public void atualizarTabuleiro(Jogador[] jogadores) {
        limparTabuleiro();
        setPosicao(jogadores[0].getPersonagem().morto() ? 'X' : jogadores[0].getPersonagem().getAparencia(), jogadores[0].getPersonagem().getX(), jogadores[0].getPersonagem().getY());
        setPosicao(jogadores[1].getPersonagem().morto() ? 'X' : jogadores[1].getPersonagem().getAparencia(), jogadores[1].getPersonagem().getX(), jogadores[1].getPersonagem().getY());
    }

    public boolean ataqueValido(Personagem atacando, Personagem parado)
    {
        return atacando.getAlcance() >= distancia(atacando, parado);
    }

    public boolean movimentoValido(int x, int y) {
        return dentroDoTabuleiro(x, y) && posicaoLivre(x, y);
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
        return matrizTabuleiro[10*y + x];
    }

    private void setPosicao(char valor, int x, int y) {
        matrizTabuleiro[10*y + x] = valor;
    }

}
