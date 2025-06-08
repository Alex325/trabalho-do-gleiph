package com.alex.dcc025.statemachine;

import com.alex.dcc025.util.Teclado;

public class EstadoFimDeJogo implements Estado {

    private boolean vitoria;

    public EstadoFimDeJogo(boolean vitoria) {
        this.vitoria = vitoria;
    }

    public void run() {
        render();
        tick();
    }

    public void render() {
        System.out.println("Parabéns! Você " + (vitoria ? "venceu" : "perdeu") + ".");
        System.out.println("Queres jogar novamente? (S/N)");
    }

    public void tick() {
        String opcao = Teclado.ler();
            while(opcao.compareTo("S") != 0 && opcao.compareTo("N") != 0) {
                System.out.println("Tenta de novo (S/N)");
                opcao = Teclado.ler();
            }

            switch (opcao) {
                case "S":
                    Maquina.maquina().transition(new EstadoTelaInicial());
                    break;
                case "N":
                    Maquina.maquina().setFimDeJogo(true);
                    break;
            }
        
    }
}
