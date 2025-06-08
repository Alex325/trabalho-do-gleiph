package com.alex.dcc025.jogo;

import com.alex.dcc025.statemachine.Maquina;
import com.alex.dcc025.util.Tela;

public class Jogo {

    private boolean running;
    private Maquina maquinaEstados;

    public Jogo() {
        this.running = true;
        this.maquinaEstados = Maquina.maquina();
    }

    public void run() {
        while (running) {
            Tela.limparTela();
            maquinaEstados.run();
            running = !maquinaEstados.jogoAcabou();
        }

    }



}
