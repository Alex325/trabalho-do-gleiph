package com.alexepablo.dcc025.engine;

import com.alexepablo.dcc025.util.Teclado;

public class EstadoFimDeJogo implements Estado {

    private final String vencedor;

    public EstadoFimDeJogo(String vencedor) {
        this.vencedor = vencedor;
    }

    @Override
    public void run() {
        render();
        tick();
    }

    @Override
    public void render() {
        System.out.println("Parabéns! Você " + (vencedor.isEmpty() ? "venceu" : "perdeu") + ".");
    }

    @Override
    public void tick() {
        String opcao = Teclado.lerOpcaoSimNao();

        switch (opcao) {
            case "S" -> Maquina.maquina().transition(new EstadoTelaInicial());
            case "N" -> Maquina.maquina().setFimDeJogo(true);
        }
        
    }
}
