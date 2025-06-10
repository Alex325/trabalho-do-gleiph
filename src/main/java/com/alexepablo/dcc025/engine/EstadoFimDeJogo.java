package com.alexepablo.dcc025.engine;

import com.alexepablo.dcc025.util.Teclado;

public class EstadoFimDeJogo implements Estado {

    private final boolean vitoria;

    public EstadoFimDeJogo(boolean vitoria) {
        this.vitoria = vitoria;
    }

    @Override
    public void run() {
        render();
        tick();
    }

    @Override
    public void render() {
        System.out.println("Parabéns! Você " + (vitoria ? "venceu" : "perdeu") + ".");
    }

    @Override
    public void tick() {
        String opcao = Teclado.lerOpcaoSimNao();

        switch (opcao) {
            case "s" -> Maquina.maquina().transition(new EstadoTelaInicial());
            case "n" -> Maquina.maquina().setFimDeJogo(true);
        }
        
    }
}
