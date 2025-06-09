package com.alex.dcc025.engine;

import com.alex.dcc025.jogo.Jogador;
import com.alex.dcc025.jogo.Tabuleiro;
import com.alex.dcc025.util.Teclado;

public class EstadoJogo implements Estado {

    private final Tabuleiro tabuleiro;

    private int turno = 0;
    private final Jogador[] jogadores;
    private Jogador proximoJogador;

    public EstadoJogo(Jogador[] jogadores) {
        tabuleiro = new Tabuleiro();
        this.jogadores = jogadores;
        proximoJogador = jogadores[turno];
    }

    @Override
    public void run() {
        render();
        tick();
    }
    @Override
    public void render() {
        tabuleiro.printTabuleiro();
    }
    @Override
    public void tick() {
        proximoJogador.jogar();
        tabuleiro.atualizarTabuleiro();
        avancarTurno();
        Teclado.ler();
    }

    private void avancarTurno() {
        turno++;
        proximoJogador = jogadores[turno % 2];
    }
}
