package com.alex.dcc025.engine;

import com.alex.dcc025.jogo.Tabuleiro;
import com.alex.dcc025.jogo.jogador.Jogador;
import com.alex.dcc025.util.Teclado;

public class EstadoJogo implements Estado {

    private final Tabuleiro tabuleiro;

    private int turno;
    private final Jogador[] jogadores;
    private Jogador proximoJogador;

    public EstadoJogo(Jogador[] jogadores) {
        turno = 0;
        tabuleiro = new Tabuleiro();
        this.jogadores = jogadores;
        
        tabuleiro.atualizarTabuleiro(this.jogadores);
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
        tabuleiro.atualizarTabuleiro(jogadores);
        avancarTurno();
        Teclado.esperarInput();
    }

    private void avancarTurno() {
        turno++;
        proximoJogador = jogadores[turno % 2];
    }
}
