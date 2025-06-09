package com.alex.dcc025.engine;

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
        estadoAtual.run();
    }

    public boolean jogoAcabou() {
        return fimDeJogo;
    }
    
    //nível de pacote, acessível para todos os estados
    void transition(Estado novoEstado) {
        estadoAtual = novoEstado;
        run();
    }
    
    //nível de pacote, acessível para todos os estados
    void setFimDeJogo(boolean acabou) {
        fimDeJogo = acabou;
    }
    
    private Maquina() {
        estadoAtual = new EstadoTelaInicial();
    }

}
