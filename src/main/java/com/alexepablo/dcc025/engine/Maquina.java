package com.alexepablo.dcc025.engine;

import com.alexepablo.dcc025.util.Tela;

public class Maquina {

    private static Maquina maquina;
    
    private boolean fimDeJogo;
    private Estado estadoAtual;

    public static Maquina maquina() {
        if (maquina == null)
            maquina = new Maquina();
        return maquina;
    }
     
    public void run() {
        Tela.limparTela();
        estadoAtual.run();
    }

    public boolean jogoAcabou() {
        return fimDeJogo;
    }
    
    
    public void transition(Estado novoEstado) {
        estadoAtual = novoEstado;
        run();
    }
    
    
    public void setFimDeJogo(boolean acabou) {
        fimDeJogo = acabou;
    }
    
    private Maquina() {
        estadoAtual = new EstadoTelaInicial();
    }

}
