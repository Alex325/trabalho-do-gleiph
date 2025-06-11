package com.alexepablo.dcc025.jogo.jogador;

import java.io.StringReader;

import com.alexepablo.dcc025.jogo.Tabuleiro;
import com.alexepablo.dcc025.jogo.personagem.Personagem;
import com.alexepablo.dcc025.util.Aleatorio;

public class JogadorIA extends Jogador {

    public JogadorIA(String nome, Personagem personagem, String tipo) {
        super(nome, personagem, tipo);
    }

    @Override
    public boolean jogar(Jogador outro, int turno) {
        System.out.println("jogando... " + this.getClass().getName());
        
        String acao = receberAcao(outro, turno);
        System.out.println("Bot vai" + acao); 
        executarAcao(acao, outro.getPersonagem());

        return false;


    }

    private String receberAcao(Jogador outro, int turno)
    {
           int chance = 0;
           switch (outro.getClasse()) {
            case "Mago" -> {
                
                if(turno%3 == 1 && turno != 1)
                    return "usar habilidade";
                if(Tabuleiro.tabuleiro().ataqueValido(this.personagem, outro.getPersonagem()))
                    return "atacar o oponente";
                if(Tabuleiro.tabuleiro().ataqueValido(outro.getPersonagem(), this.personagem))    
                {
                    if(this.personagem.getVida() <= 30)
                        chance = Aleatorio.numeroAleatorio(2);
                    if(chance%2 == 0)
                        return "se mover para perto do oponente";
                    return "se defender";   
                }
                
                chance = Aleatorio.numeroAleatorio(2);

                if(chance%2 == 0)
                    return "se mover para perto do oponente";
                return "se mover para longe do oponente";     

            }
            case "Arqueiro" ->{

                if(turno%2 == 0 && Tabuleiro.tabuleiro().ataqueValido(outro.getPersonagem(), this.personagem))
                {
                    chance = Aleatorio.numeroAleatorio(2);
                    if(chance%2 == 0)
                        return "se defender";
                    return "se mover para longe do oponente";    

                }

                if(Tabuleiro.tabuleiro().ataqueValido(this.personagem, outro.getPersonagem()))
                    return "atacar o oponente";
                else
                    return "usar habilidade";    

            }
            case "Guerreiro"->{
                if(turno == 1)
                    return "usar habilidade";
                if(Tabuleiro.tabuleiro().ataqueValido(this.personagem, outro.getPersonagem()))  
                    return "atacar o oponente";
                if(this.personagem.getVida() <= 30)
                   chance = Aleatorio.numeroAleatorio(2);
                if(chance%2 == 0)
                   return "se mover para perto do oponente";
                return "se defender";     
            }
    }

    private void executarAcao(String acao, Personagem outro)
    {

        int deltaX, deltaY;
        deltaX = deltaY = 0;
            switch (acao) {
                case "atacar o oponente" ->{
                    this.personagem.atacar(outro);

                }
                
                case "se defender" ->{
                    this.defender();

                }

                case "se mover para perto do oponente"->{

                    if(Math.abs(this.personagem.getX() - outro.getX()) > Math.abs(this.personagem.getY() - outro.getY()) )
                        deltaX = movimentoEixoX(outro);
                    else
                        deltaY = movimentoEixoY(outro);
                    this.personagem.mover(deltaX, deltaY);
                }

                case "se mover para longe do oponente" ->{ 

                    if(Math.abs(this.personagem.getX() - outro.getX()) > Math.abs(this.personagem.getY() - outro.getY()) )
                       deltaX = -movimentoEixoX(outro);
                    else
                        deltaY = -movimentoEixoY(outro);
                    this.personagem.mover(deltaX, deltaY); 

                }

                case "usar habilidade" ->{
                    this.personagem.habilidadeEspecial();

                }
                default:
                return;
    
            }

            
    }



    private int movimentoEixoX(Personagem outro)
    {
         if(this.personagem.getX() > outro.getX() )
                            return -1;
                       else 
                            return 1;
    }

    private int movimentoEixoY(Personagem outro)
    {
         if(this.personagem.getY() > outro.getY() )
                            return -1;
                       else 
                            return 1;
    }


}
