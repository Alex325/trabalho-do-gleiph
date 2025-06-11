package com.alexepablo.dcc025.jogo.jogador;

import com.alexepablo.dcc025.jogo.Tabuleiro;
import com.alexepablo.dcc025.jogo.personagem.Personagem;
import com.alexepablo.dcc025.util.Teclado;

public class JogadorHumano extends Jogador {

    public JogadorHumano(String nome, Personagem personagem, String tipo) {
        super(nome, personagem, tipo);
    }

    @Override
    public void jogar(Jogador outro) {
        String acao = Teclado.lerAcao();
        decidirAcao(acao, outro);
    }

    private void decidirAcao(final String acao, Jogador outro) {
        switch (acao) {
            case "M" -> this.mover();
            case "A" -> {
                if (this.atacar(outro)) return;

                Teclado.limparLinha(1);
                System.out.println("Ataque inválido. Tenta outra ação.");
                Teclado.esperarInput();
                Teclado.limparLinha(3);
                jogar(outro);

            }
            case "D" -> this.defender();
            case "E" -> { 
                if (this.habilidadeEspecial()) return;

                Teclado.limparLinha(1);
                System.out.println("Habilidade indisponível. Tenta outra ação.");
                Teclado.esperarInput();
                Teclado.limparLinha(3);
                jogar(outro);
            }
        }
    }

    private void mover() {
        
        int deltaX = 0, deltaY = 0;
        
        while(!Tabuleiro.tabuleiro().movimentoValido(this.personagem.getX() + deltaX, this.personagem.getY() + deltaY)) {        
            deltaX = deltaY = 0;
            
            String direcao = Teclado.lerDirecao();

            switch (direcao) {
                case "W" -> deltaY = -1;
                case "A" -> deltaX = -1;
                case "S" -> deltaY = 1;
                case "D" -> deltaX = 1;
            }

        }

        this.personagem.mover(deltaX, deltaY);
    }
}
