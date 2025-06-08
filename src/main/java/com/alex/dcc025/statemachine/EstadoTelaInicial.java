package com.alex.dcc025.statemachine;

public class EstadoTelaInicial implements Estado{

    public void run() {
        render();
        tick();
    }

    public void render() {
        System.out.println("A implementar...");
    }    
    public void tick() {
        Maquina.maquina().transition(new EstadoFimDeJogo(true));
    }
}
