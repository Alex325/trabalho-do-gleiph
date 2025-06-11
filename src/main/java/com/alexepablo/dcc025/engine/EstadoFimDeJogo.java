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
        String mensagemFimDeJogo;
        if (vencedor.compareTo("Inimigo") == 0) {
            mensagemFimDeJogo = String.format("Que pena. %s venceu.", vencedor);
        }
        else {
            mensagemFimDeJogo = String.format("Parabéns. Jogador %s venceu.", vencedor);
        }
        System.out.println(mensagemFimDeJogo);
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
