package com.alex.dcc025.util;

import java.util.Scanner;

public class Teclado {
    
    private static Scanner teclado = new Scanner(System.in);

    public static String ler() {
        return teclado.nextLine();
    }
}
