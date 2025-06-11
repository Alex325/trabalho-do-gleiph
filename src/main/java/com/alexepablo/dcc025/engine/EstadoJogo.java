package com.alexepablo.dcc025.engine;

import com.alexepablo.dcc025.jogo.Tabuleiro;
import com.alexepablo.dcc025.jogo.jogador.Jogador;
import com.alexepablo.dcc025.util.Teclado;

public class EstadoJogo implements Estado {

    private final Tabuleiro tabuleiro;

    private int turno;
    private final Jogador[] jogadores;
    private Jogador jogandoAgora;
    private Jogador proximoJogador;

    public EstadoJogo(Jogador[] jogadores) {
        turno = 0;
        tabuleiro = Tabuleiro.tabuleiro();
        this.jogadores = jogadores;
        
        prepararPrimeiroTurno();
    }
    
    private void prepararPrimeiroTurno() {
        tabuleiro.atualizarTabuleiro(this.jogadores);

        jogandoAgora = jogadores[turno];
        proximoJogador = jogadores[turno + 1];

        tabuleiro.printTabuleiro();
        jogandoAgora.printStatus();
    }

    @Override
    public void run() {
        render();
        tick();
        Teclado.esperarInput();
    }
    @Override
    public void render() {
        tabuleiro.printTabuleiro();
        jogandoAgora.printStatus();
    }

    @Override
    public void tick() {
        jogandoAgora.jogar(proximoJogador);
        tabuleiro.atualizarTabuleiro(jogadores);
        avancarTurno();
    }

    private void avancarTurno() {
        turno++;
        jogandoAgora = jogadores[turno % 2];
        proximoJogador = jogadores[(turno + 1) % 2];
    }
}
