package com.alexepablo.dcc025.jogo.personagem;


public class Validadora
{

    public boolean validarPosicaoInicial(int x1, int y1, int x2, int y2 )
    {
        return x1 != x2 || y1 != y2;
         
    }
    
    
    
    /*public boolean validarMovimento(Personagem emMovimento, Personagem parado, String movimentoDeA)
    {
       switch(movimentoDeA)
       {
           case "C" -> { return !(emMovimento.getY() + 1 == parado.getY() && emMovimento.getX() == parado.getX() || emMovimento.getY() + 1 > 9); }
           case "B" ->
               if(emMovimento.getY() - 1 == parado.getY() && emMovimento.getX() == parado.getX()  )
                   return false;
               if(emMovimento.getY() - 1 < 0)
                   return false;
               break;
           case "E":
               if(emMovimento.getX() - 1  == parado.getX() && emMovimento.getY() == parado.getY() )
                   return false;
               if(emMovimento.getX() - 1 < 0)
                   return false;
               break;
           case "D":
               if(emMovimento.getX() + 1 == parado.getX() && emMovimento.getY() == parado.getY() )
                   return false;
               if(emMovimento.getX() + 1 > 9)
                   return false;
               break;
       }
       return true;
    }
    
    private int distancia(Personagem atacando, Personagem parado)
    {   
        return Math.max(Math.abs(atacando.getX() - parado.getX()),Math.abs(atacando.getY() - parado.getY());
    }*/
    
    
}
