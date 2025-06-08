package com.alex.dcc025.jogo;

import com.alex.dcc025.statemachine.Maquina;

public class Jogo {

    private boolean running;
    private Maquina maquinaEstados;

    public Jogo() {
        this.running = false;
        this.maquinaEstados = new Maquina();
    }

    public void run() {

        while (running) {
            maquinaEstados.run();
        }

    }



}
