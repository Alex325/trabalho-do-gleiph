package com.alexepablo.dcc025.jogo;

import com.alexepablo.dcc025.engine.Maquina;

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
