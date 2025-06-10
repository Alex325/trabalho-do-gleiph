package com.alex.dcc025.util;

import java.util.Random;

public class Aleatorio {
    private static final Random random = new Random();

    public static int[] gerarPosicao() {
        int[] posicao = new int[2];
        posicao[0] = random.nextInt(10);
        posicao[1] = random.nextInt(10);
        return posicao;
    }

    public static int[] gerarPosicaoDistinta(int[] outraPosicao) {
        int[] posicao = new int[2];
        
        do {
            posicao[0] = random.nextInt(10);
            posicao[1] = random.nextInt(10);
        } while (outraPosicao[0] == posicao[0] && outraPosicao[1] == posicao[1]);

        return posicao;
    }

    public static int numeroAleatorio(int limite) {
        return random.nextInt(limite);
    }
}
