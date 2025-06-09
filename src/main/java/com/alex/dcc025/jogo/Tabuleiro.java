package com.alex.dcc025.jogo;

public class Tabuleiro {
    private char[] tabuleiro = new char[10*10];


    public Tabuleiro() {
        for (int i = 0; i < 100; i++) {
            tabuleiro[i] = '.';
        }
    }

    public void printTabuleiro() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tabuleiro[10*i + j] + " ");
            }

            System.out.print("\n");
        }
    }

    public void atualizarTabuleiro() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                /*if (jogador.getX() == i && jogador.getY() == j) {
                    tabuleiro[10*i + j] = jogador.getAparencia();
                }
                else if (inimigo.getX() == i && inimigo.getY() == j) {
                    tabuleiro[10*i + j] = inimigo.getAparencia();
                }
                else {*/
                    tabuleiro[10*i + j] = '.';
                //}
            }

            System.out.print("\n");
        }
    }
}
