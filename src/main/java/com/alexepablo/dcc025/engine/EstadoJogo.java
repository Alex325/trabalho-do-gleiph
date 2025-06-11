package com.alexepablo.dcc025.engine;

import com.alexepablo.dcc025.jogo.Tabuleiro;
import com.alexepablo.dcc025.jogo.jogador.Jogador;
import com.alexepablo.dcc025.util.Teclado;
import com.alexepablo.dcc025.util.Tela;

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

        checkFimDeJogo();
        avancarTurno();
    }

    private void checkFimDeJogo() {
        String vencedor = encerrarJogo(jogadores);

        if (vencedor.isEmpty()) return;

        Tela.limparTela();

        Tabuleiro.tabuleiro().printTabuleiro();

        System.out.println("Fim de Jogo. O vencedor é o Jogador " + vencedor);

        System.out.println("Pressione para continuar...");

        Teclado.esperarInput();

        Maquina.maquina().transition(new EstadoFimDeJogo(vencedor));
    }

    private void avancarTurno() {
        turno++;
        jogandoAgora = jogadores[turno % 2];
        proximoJogador = jogadores[(turno + 1) % 2];
    }

    private String encerrarJogo(Jogador[] jogadores) {
        for (int i = 0; i < 2; i++) {
            if (jogadores[i].getPersonagem().getVida() == 0) return jogadores[(i+1) % 2].getTipo();
        }
        return "";
    }
}
