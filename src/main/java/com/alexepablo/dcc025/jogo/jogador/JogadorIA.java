package com.alexepablo.dcc025.jogo.jogador;


import com.alexepablo.dcc025.jogo.Tabuleiro;
import com.alexepablo.dcc025.jogo.personagem.Personagem;
import com.alexepablo.dcc025.util.Aleatorio;
import com.alexepablo.dcc025.util.Teclado;

public class JogadorIA extends Jogador {

    private static enum Acao {
        atacar,
        defender,
        habilidade,
        aproximar,
        fugir
    }

    public JogadorIA(String nome, Personagem personagem, String tipo) {
        super(nome, personagem, tipo);
    }

    @Override
    public boolean jogar(Jogador outro, int turno) {
        System.out.println("Inimigo vai jogar");
        
        Teclado.esperarInput();

        Acao acao = receberAcao(outro, turno);

        Teclado.limparLinha(2);

        System.out.println("Inimigo vai " + acaoToString(acao)); 
        executarAcao(acao, outro.getPersonagem());

        Teclado.esperarInput();

        return false;


    }

    private String acaoToString(Acao acao) {
        String acaoString = "";

        switch (acao) {
            case Acao.atacar -> acaoString = "atacar";
            
            case Acao.defender -> acaoString = "defender";

            case Acao.aproximar -> acaoString = "se aproximar";

            case Acao.fugir -> acaoString = "fugir";

            case Acao.habilidade -> acaoString = "usar habilidade";
            
        }

        return acaoString;

    }

    private Acao receberAcao(Jogador outro, int turno)
    {
           int chance = 0;

           
           switch (this.personagem.getClasse()) {
               case "Mago" ->  {
                
                if (turno % 2 == 1 && turno != 1)
                    return Acao.habilidade;

                if (Tabuleiro.tabuleiro().ataqueValido(this.personagem, outro.getPersonagem()))
                    return Acao.atacar;

                if (Tabuleiro.tabuleiro().ataqueValido(outro.getPersonagem(), this.personagem))    
                {
                    if (this.personagem.getVida() <= 30)
                        chance = Aleatorio.numeroAleatorio(2);

                    if (chance % 2 == 0)
                        return Acao.aproximar;

                    return Acao.defender;   
                }
                
                chance = Aleatorio.numeroAleatorio(2);

                if (chance % 2 == 0)
                    return Acao.aproximar;
                return Acao.fugir;     

            }
            case "Arqueiro" -> {

                if (turno % 2 == 0 && Tabuleiro.tabuleiro().ataqueValido(outro.getPersonagem(), this.personagem))
                {
                    chance = Aleatorio.numeroAleatorio(2);
                    if (chance % 2 == 0)
                        return Acao.defender;
                    return Acao.fugir;    

                }

                if (Tabuleiro.tabuleiro().ataqueValido(this.personagem, outro.getPersonagem()))
                    return Acao.atacar;
                else
                    return Acao.habilidade;    
            }
            case "Guerreiro" -> {
                if (turno == 1)
                    return Acao.habilidade;

                if (Tabuleiro.tabuleiro().ataqueValido(this.personagem, outro.getPersonagem()))  
                    return Acao.atacar;

                if (this.personagem.getVida() <= 30)
                   chance = Aleatorio.numeroAleatorio(2);

                if (chance % 2 == 0)
                   return Acao.aproximar;

                return Acao.defender;     
            }
        }

        return Acao.defender;
    }

    private void executarAcao(Acao acao, Personagem outro)
    {

        int deltaX, deltaY;
        deltaX = deltaY = 0;
            switch (acao) {
                case Acao.atacar -> {
                    this.personagem.atacar(outro);

                }
                
                case Acao.defender -> {
                    this.defender();

                }

                case Acao.aproximar-> {

                    if (Math.abs(this.personagem.getX() - outro.getX()) > Math.abs(this.personagem.getY() - outro.getY()) )
                        deltaX = movimentoEixoX(outro);
                    else
                        deltaY = movimentoEixoY(outro);
                    this.personagem.mover(deltaX, deltaY);
                }

                case Acao.fugir -> { 

                    if (Math.abs(this.personagem.getX() - outro.getX()) > Math.abs(this.personagem.getY() - outro.getY()) )
                       deltaX = -movimentoEixoX(outro);
                    else
                        deltaY = -movimentoEixoY(outro);
                    this.personagem.mover(deltaX, deltaY); 

                }

                case Acao.habilidade -> {
                    this.personagem.habilidadeEspecial(outro);
                }
    
            }

            
    }



    private int movimentoEixoX(Personagem outro)
    {
         if (this.personagem.getX() > outro.getX() )
                            return -1;
                       else 
                            return 1;
    }

    private int movimentoEixoY(Personagem outro)
    {
         if (this.personagem.getY() > outro.getY() )
                            return -1;
                       else 
                            return 1;
    }


}
