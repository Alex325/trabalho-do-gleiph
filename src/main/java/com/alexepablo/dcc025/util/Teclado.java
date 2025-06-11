package com.alexepablo.dcc025.util;

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
        List<String> modosValidos = Arrays.asList("1", "2");

        System.out.println("Escolha um modo de jogo:");
        System.out.println("Contra humano (1) | Contra bot (2)");

        String modo = ler();

        while (!modosValidos.contains(modo)) {
            limparLinha(2);
            System.out.println("Modo inválido (1 | 2)");
            modo = ler();
        }

        return modo;
    }

    public static String lerOpcaoClasse() {
        List<String> classesValidas = Arrays.asList("G", "M", "A");

        System.out.println("Digita a classe do teu personagem (Guerreiro (G) | Mago (M) | Arqueiro (A))");
        
        String classe = ler().toUpperCase();
        
        while(!classesValidas.contains(classe)) {
            limparLinha(2);
            System.out.println("Classe inválida (G | M | A)");
            classe = ler().toUpperCase();
        }

        return classe;
    }

    public static String lerOpcaoSimNao() {
        List<String> opcoesValidas = Arrays.asList("S", "N");
        
        System.out.println("Queres jogar novamente? (S | N)");
        
        String opcao = ler().toUpperCase();
        
        while(!opcoesValidas.contains(opcao)) {
            limparLinha(2);
            
            System.out.println("Opção inválida (S | N)");
            opcao = ler().toUpperCase();
        }

        return opcao;
    }

    public static String lerNome() {
        Tela.limparTela();
        System.out.println("Digita o nome do teu personagem");
        String nome = ler();
        return nome;
    }

    public static String lerAcao() {
        List<String> acoesValidas = Arrays.asList("M", "A", "D", "E");

        System.out.println("Escolhe a tua ação (Mover (M) | Atacar (A) | Defender (D) | Especial (E))");

        String acao = ler().toUpperCase();

        while(!acoesValidas.contains(acao)) {
            limparLinha(2); 
            System.out.println("Ação inválida (M | A | D | E)");
            acao = ler().toUpperCase();
        }

        return acao;

    }
    public static String lerDirecao() {
        List<String> direcoesValidas = Arrays.asList("W", "A", "S", "D");

        limparLinha(2);

        System.out.println("Escolhe a direção (Cima (W) | Baixo (S) | Esquerda (A) | Direita (D))");

        String direcao = ler().toUpperCase();

        while(!direcoesValidas.contains(direcao)) {
            limparLinha(2);
            System.out.println("Direção inválida (W | A | S | D)");
            direcao = ler().toUpperCase();
        }

        return direcao;

    }

    public static void limparLinha(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            System.out.print("\033[1A");
            System.out.print("\033[2K");
        }
        System.out.flush();
    }
}
