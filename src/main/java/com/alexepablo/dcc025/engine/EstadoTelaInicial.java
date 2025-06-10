package com.alexepablo.dcc025.engine;

<<<<<<< HEAD:src/main/java/com/alexepablo/dcc025/engine/EstadoTelaInicial.java
import com.alexepablo.dcc025.jogo.jogador.Jogador;
import com.alexepablo.dcc025.jogo.jogador.JogadorHumano;
import com.alexepablo.dcc025.jogo.jogador.JogadorIA;
import com.alexepablo.dcc025.jogo.personagem.Arqueiro;
import com.alexepablo.dcc025.jogo.personagem.Guerreiro;
import com.alexepablo.dcc025.jogo.personagem.Mago;
import com.alexepablo.dcc025.util.Aleatorio;
import com.alexepablo.dcc025.util.Teclado;
import com.alexepablo.dcc025.util.Tela;
=======
import com.alex.dcc025.jogo.jogador.Jogador;
import com.alex.dcc025.jogo.jogador.JogadorHumano;
import com.alex.dcc025.jogo.jogador.JogadorIA;
import com.alex.dcc025.jogo.personagem.Arqueiro;
import com.alex.dcc025.jogo.personagem.Guerreiro;
import com.alex.dcc025.jogo.personagem.Mago;
import com.alex.dcc025.util.Aleatorio;
import com.alex.dcc025.util.Teclado;
import com.alex.dcc025.util.Tela;
>>>>>>> 1c585f6 (conflitos resolvidos, integrar mecânicas):src/main/java/com/alex/dcc025/engine/EstadoTelaInicial.java

public class EstadoTelaInicial implements Estado {

    @Override
    public void run() {
        render();
        tick();
    }

    @Override
    public void render() {
        System.out.println("Duelo de Personagens");
        System.out.println("Pressione para jogar...");
        Teclado.esperarInput();
    }

    @Override
    public void tick() {
        String modo = Teclado.lerModo();

        Jogador[] jogadores = new Jogador[2];

        Tela.limparTela();

        switch (modo) {
            case "1" -> montarDoisJogadores(jogadores);
            case "2" -> montarJogadorEBot(jogadores);
        }

        Maquina.maquina().transition(new EstadoJogo(jogadores));
    }

    private void montarDoisJogadores(Jogador[] jogadores) {
        montarJogadorUm(jogadores);
        Tela.limparTela();
        montarJogadorDois(jogadores);
    }

    private void montarJogadorEBot(Jogador[] jogadores) {
        montarJogadorUm(jogadores);
        Tela.limparTela();
        montarBot(jogadores);
    }

    private void montarJogadorUm(Jogador[] jogadores) {

        System.out.println("Jogador 1");

        String classe = Teclado.lerOpcaoClasse();
        String nome = Teclado.lerNome();

        int[] xEy = Aleatorio.gerarPosicao();

        switch (classe) {
            case "G" -> jogadores[0] = new JogadorHumano(nome, new Guerreiro(xEy[0], xEy[1]));
            case "M" -> jogadores[0] = new JogadorHumano(nome, new Mago(xEy[0], xEy[1]));
            case "A" -> jogadores[0] = new JogadorHumano(nome, new Arqueiro(xEy[0], xEy[1]));
        }
        
    }

    private void montarJogadorDois(Jogador[] jogadores) {
        System.out.println("Jogador 2");

        String classe = Teclado.lerOpcaoClasse();
        String nome = Teclado.lerNome();

        int[] outroXeY = { jogadores[0].getPersonagem().getX(), jogadores[0].getPersonagem().getY() };

        int[] xEy = Aleatorio.gerarPosicaoDistinta(outroXeY);


        switch (classe) {
            case "G" -> jogadores[1] = new JogadorHumano(nome, new Guerreiro(xEy[0], xEy[1]));
            case "M" -> jogadores[1] = new JogadorHumano(nome, new Mago(xEy[0], xEy[1]));
            case "A" -> jogadores[1] = new JogadorHumano(nome, new Arqueiro(xEy[0], xEy[1]));
        }
    }

    private void montarBot(Jogador[] jogadores) {
        final String[][] nomes = {
                            {
                                "Tharn Brado-Ferro",
                                "Ragna Lâmina-Petra",
                                "Garruk Mão-de-Aço",
                                "Brynn Véu-de-Ferro",
                                "Kaelor Chifre-Terrível",
                                "Durnek Véu-de-Machado",
                                "Mava da Lança-Rubra",
                                "Varkos Mandíbula-Ígnea",
                                "Hrodan Guarda-Chamas",
                                "Sela Martelo-Trovão"
                            },
                            {
                                "Eldryn, o Pálido",
                                "Miras Sussurrador",
                                "Thaelion Faísca-Crepuscular",
                                "Virella Tramadaluar",
                                "Korven, o Vinculoglifo",
                                "Zalith Chamado-do-Fogo",
                                "Orelan Plumaurora",
                                "Fyraeth, a Tecelã do Véu",
                                "Jorthan Nascido-da-Névoa",
                                "Calyra Canto-Cinzento"
                            },
                            {
                                "Sylra Flecha-Névoa",
                                "Kaelen Marca-do-Cardo",
                                "Dorel Pena-Viva",
                                "Thira Ruina-da-folha",
                                "Naren Brilho-da-Raposa",
                                "Vellan do Vazio",
                                "Serik Passo-do-Pinheiro",
                                "Elwyn Eixo-estelar",
                                "Jessa Pena-espinho",
                                "Coran Sombrilongo"
                            }
                        };
            
        int classe = Aleatorio.numeroAleatorio(3);
        int idxNome = Aleatorio.numeroAleatorio(10);
        
        String nome = nomes[classe][idxNome];

        int[] outroXeY = { jogadores[0].getPersonagem().getX(), jogadores[0].getPersonagem().getY() };

        int[] xEy = Aleatorio.gerarPosicaoDistinta(outroXeY);

        switch (classe) {
            case 0 -> jogadores[1] = new JogadorIA(nome, new Guerreiro(xEy[0], xEy[1]));
            case 1 -> jogadores[1] = new JogadorIA(nome, new Mago(xEy[0], xEy[1]));
            case 2 -> jogadores[1] = new JogadorIA(nome, new Arqueiro(xEy[0], xEy[1]));
        }
    }
}
