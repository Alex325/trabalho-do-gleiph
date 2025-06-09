package com.alex.dcc025.engine;

import com.alex.dcc025.jogo.Jogador;
import com.alex.dcc025.jogo.JogadorHumano;
import com.alex.dcc025.jogo.JogadorIA;

public class EstadoTelaInicial implements Estado{

    @Override
    public void run() {
        render();
        tick();
    }

    @Override
    public void render() {
        System.out.println("A implementar...");
    }    
    @Override
    public void tick() {
        Jogador[] jogadores = new Jogador[2];
        jogadores[0] = new JogadorHumano("AAAA");
        jogadores[1] = new JogadorIA("BBBB");
        Maquina.maquina().transition(new EstadoJogo(jogadores));
    }
}
