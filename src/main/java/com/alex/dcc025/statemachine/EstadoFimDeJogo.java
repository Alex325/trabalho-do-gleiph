package com.alex.dcc025.statemachine;

import com.alex.dcc025.util.Teclado;

public class EstadoFimDeJogo implements Estado {

    private boolean vitoria;
    private boolean fimDeJogo;

    public void run() {
        render();
        tick();
    }

    public void render() {
        System.out.println("Parabéns! Você " + (vitoria ? "venceu" : "perdeu"));
        System.out.println("Queres jogar novamente? (S/N)");
    }

    public void tick() {
        String opcao = Teclado.ler();
        switch (opcao) {
            case "S":

                break;
            case "N":

                break;
            default:
                System.out.println("Tenta de novo (S/N)");
                break;
        }
    }
}
