package com.alex.dcc025.engine;

import com.alex.dcc025.util.Teclado;

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
        System.out.println("Queres jogar novamente? (S/N)");
    }

    @Override
    public void tick() {
        String opcao = Teclado.ler();
            while(opcao.compareToIgnoreCase("s") != 0 && opcao.compareToIgnoreCase("n") != 0) {
                System.out.println("Tenta de novo (S/N)");
                opcao = Teclado.ler();
            }

            switch (opcao.toLowerCase()) {
                case "s" -> Maquina.maquina().transition(new EstadoTelaInicial());
                case "n" -> Maquina.maquina().setFimDeJogo(true);
            }
        
    }
}
