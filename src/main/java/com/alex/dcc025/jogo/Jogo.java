package com.alex.dcc025.jogo;

import com.alex.dcc025.engine.Maquina;
import com.alex.dcc025.util.Tela;

public class Jogo {

    private boolean running;
    private final Maquina maquinaEstados;

    public Jogo() {
        this.running = true;
        this.maquinaEstados = Maquina.maquina();
    }

    public void run() {
        while (running) {
            maquinaEstados.run();
            running = !maquinaEstados.jogoAcabou();
        }

    }



}
