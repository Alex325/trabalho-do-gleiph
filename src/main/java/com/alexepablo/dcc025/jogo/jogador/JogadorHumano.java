package com.alexepablo.dcc025.jogo.jogador;

import com.alexepablo.dcc025.jogo.Tabuleiro;
import com.alexepablo.dcc025.jogo.personagem.Personagem;
import com.alexepablo.dcc025.util.Teclado;

public class JogadorHumano extends Jogador {

    public JogadorHumano(String nome, Personagem personagem, String tipo) {
        super(nome, personagem, tipo);
    }

    @Override
    public boolean jogar(Jogador outro, int turno) {
        String acao = Teclado.lerAcao();
        return decidirAcao(acao, outro);
    }

    private boolean decidirAcao(final String acao, Jogador outro) {

        boolean forfeit = false;

        switch (acao) {
            case "M" -> { this.mover(); }
            case "A" -> {
                if (this.atacar(outro)) break;

                Teclado.limparLinha(1);
                System.out.println("Ataque inválido. Perdeste a vez.");
                Teclado.esperarInput();
            }
            case "D" -> { this.defender(); }
            case "E" -> {
                if (this.habilidadeEspecial(outro.getPersonagem())) break;

                Teclado.limparLinha(1);
                System.out.println("Habilidade indisponível. Tenta outra ação.");
                Teclado.esperarInput();
                Teclado.limparLinha(3);
                jogar(outro, 0);

            }
            case "S" -> { forfeit = this.sair(); }
        }

        return forfeit;
    }

    private boolean sair() {
        return true;
    }

    private void mover() {
        
        int deltaX, deltaY;
        
        boolean movimentoValido = true;

        do {
            deltaX = deltaY = 0;
            
            String direcao = Teclado.lerDirecao(movimentoValido);
            
            switch (direcao) {
                case "W" -> deltaY = -1;
                case "A" -> deltaX = -1;
                case "S" -> deltaY = 1;
                case "D" -> deltaX = 1;
            }
            
            movimentoValido = Tabuleiro.tabuleiro().movimentoValido(this.personagem.getX() + deltaX, this.personagem.getY() + deltaY);

            if (!movimentoValido) {
                System.out.println();
            }
            
        }
        while(!Tabuleiro.tabuleiro().movimentoValido(this.personagem.getX() + deltaX, this.personagem.getY() + deltaY));

        this.personagem.mover(deltaX, deltaY);
    }
}
