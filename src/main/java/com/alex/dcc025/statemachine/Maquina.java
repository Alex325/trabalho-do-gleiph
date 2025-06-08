package com.alex.dcc025.statemachine;

public class Maquina {
    private boolean fimDeJogo;
    private Estado estadoAtual;

    public Maquina() {
        estadoAtual = new EstadoFimDeJogo();        
    }

    public void run() {
        estadoAtual.run();
    }

    public void transition(Estado novoEstado) {
        estadoAtual = novoEstado;
        run();
    }
}
