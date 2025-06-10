package com.alexepablo.dcc025.util;


<<<<<<< HEAD:src/main/java/com/alexepablo/dcc025/util/Teclado.java
=======

>>>>>>> 1c585f6 (conflitos resolvidos, integrar mecânicas):src/main/java/com/alex/dcc025/util/Teclado.java
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Teclado {
    
    private static final Scanner teclado = new Scanner(System.in);

    private static String ler() {
        return teclado.nextLine();
    }

    public static void esperarInput() {
        ler();
    }

    public static String lerModo() {
        List<String> modosValidas = Arrays.asList("1", "2");

        String modo;
        do {
            Tela.limparTela();
            System.out.println("Escolha um modo de jogo:");
            System.out.println("Contra humano (1) | Contra bot (2)");
            modo = Teclado.ler();
        } while (!modosValidas.contains(modo));

        return modo;
    }

    public static String lerOpcaoClasse() {
        List<String> classesValidas = Arrays.asList("G", "M", "A");

        System.out.println("Digita a classe do teu personagem (Guerreiro - (G) | Mago - (M) | Arqueiro - (A))");
        
        String classe = ler().toUpperCase();
        
        while(!classesValidas.contains(classe)) {
            System.out.println("Tenta de novo (G | M | A)");
            classe = ler().toUpperCase();
        }

        return classe;
    }

    public static String lerOpcaoSimNao() {
        List<String> opcoesValidas = Arrays.asList("s", "n");
        
        System.out.println("Queres jogar novamente? (S | N)");
        
        String opcao = ler().toLowerCase();
        
        while(!opcoesValidas.contains(opcao)) {
            System.out.println("Tenta de novo (S | N)");
            opcao = ler().toLowerCase();
        }

        return opcao;
    }

    public static String lerNome() {
        System.out.println("Digita o nome do teu personagem");
        String nome = ler();
        return nome;
    }
}
