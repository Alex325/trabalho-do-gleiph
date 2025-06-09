package com.alex.dcc025.util;

public class Tela {
    public static void limparTela() {

        System.out.print("\033[H\033[2J");
        System.out.flush();

    }
}
