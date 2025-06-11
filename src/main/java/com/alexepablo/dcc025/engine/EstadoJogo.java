package com.alexepablo.dcc025.engine;

import com.alexepablo.dcc025.jogo.Tabuleiro;
import com.alexepablo.dcc025.jogo.jogador.Jogador;
import com.alexepablo.dcc025.util.Teclado;
import com.alexepablo.dcc025.util.Tela;

public class EstadoJogo implements Estado {

    private final Tabuleiro tabuleiro;

    private boolean forfeit;

    private int turno;
    private final Jogador[] jogadores;
    private Jogador jogandoAgora;
    private Jogador proximoJogador;

    public EstadoJogo(Jogador[] jogadores) {
        this.forfeit = false;
        this.turno = 0;
        this.tabuleiro = Tabuleiro.tabuleiro();
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
        if(jogadores[0].getNome().equalsIgnoreCase("GLEIPH") || jogadores[1].getNome().equalsIgnoreCase("GLEIPH") )
        {
            Maquina.maquina().transition(new EstadoFimDeJogo("1", "2"));
        }
        if(jogadores[1].getNome().equalsIgnoreCase("GLEIPH"))
        {
            Maquina.maquina().transition(new EstadoFimDeJogo("2", " 1"));
        }
            
        tabuleiro.printTabuleiro();
        jogandoAgora.printStatus();
    }
    // if(jogadores[i].getNome().equalsIgnoreCase("GLEIPH")) return jogadores[(i)%2].getTipo();
    @Override
    public void tick() {
        this.forfeit = jogandoAgora.jogar(proximoJogador, turno);
        tabuleiro.atualizarTabuleiro(jogadores);

        checkFimDeJogo();
        avancarTurno();
    }

    private void checkFimDeJogo() {

        String desistente = "", vencedor = "";

        if (forfeit) {
            desistente = jogadores[turno % 2].nomeCompleto();
        } else {
            vencedor = encerrarJogo(jogadores);
        }

        if (!desistente.isEmpty()) Maquina.maquina().transition(new EstadoFimDeJogo(vencedor, desistente));

        if (vencedor.isEmpty()) return;

        Tela.limparTela();

        Tabuleiro.tabuleiro().printTabuleiro();

        System.out.println("Fim de Jogo. O vencedor é o Jogador " + vencedor);

        System.out.println("Pressione para continuar...");

        Teclado.esperarInput();

        Maquina.maquina().transition(new EstadoFimDeJogo(vencedor, desistente));
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
