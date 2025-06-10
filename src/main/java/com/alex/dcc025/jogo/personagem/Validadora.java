/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.jogo;

/**
 *
 * @author rachi
 */
public class Validadora
{
    public validadora()
    {
        //?
    }
    
    public boolean validaPosicaoInicial(int x1, int y1, int x2, int y2 )
    {
        return x1 != x2 || y1 != y2;
         
    }
    
    public boolean validaAtaque(Personagem atacando, Personagem parado)
    {
        return atacando.getAlcance() >= distancia(atacando, parado);
         
    }
    
    public boolean validaMovimento(Personagem emMovimento, Personagem parado, char movimentoDeA)
    {
       switch(movimentoDeA)
       {
           case "C":
               if(emMovimento.getY() + 1 == parado.getY() && emMovimento.getX() == parado.getX()  )
                   return false;
               if(emMovimento.getY() + 1 > 9)
                   return false
               break;
           case "B":
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
            //default?
       }
       return true;
    }
    
    private int distancia(Personagem atacando, Personagem parado)
    {   
        return MATH.max(MATH.abs(atacando.getX()-parado.getX()),MATH.abs(atacando.getY() - parado.getY());
    }
    
    
}
