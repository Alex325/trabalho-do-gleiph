/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.jogo;

/**
 *
 * @author rachi
 */

public class Personagem 
{
    public Personagem( char aparencia, String classe, int defesaInicial)
    {
       this.aparencia = aparencia;
       this.defesaInicial = defesaInicial;
       this.classe = classe;
    }
    
    public  atacar(Personagem Alvo)
    {
        Alvo.receberDano( ataque);
    }
    
    public void defender()
    {
        defesa = defesaInicial;
    }
    
    public void Movimento(int deltaX, int deltaY)
    {
        x = x + deltaX;
        y = y + deltaY;
    }
    
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    public void setX()
    {
        this.x = x;
    }
    
    public void setY(int y)
    {
        this.y = y;
    }
    
    public void setDefesa(int defesa)
    {
        this.defesa = defesa;
    }
    
    public int getX()
    {
        return y;
    }
    
    public int getY()
    {
        return x;
    }
    
    public void setVida(int vida)
    {
        this.vida = vida; 
    }
    
    public int getVida()
    {
        return vida;
    }
    
    public void setAlcance(int alcance)
    {
        this.alcance = alcance;
    }
    public int getAlcance()
    {
        return alcance;
    }
 
    public void setAtaque()
    {
        this.ataque = ataque;
    }
    public int getAtaque()
    {
        return ataque;
    }
    public char getAparencia()
    {
        return aparencia;
    }
    
    public void ReceberDano(int dano)
    {
        int defesaPosAtaque = MATH.math(0,defesa - dano);
        defesa = defesaPosAtaque;
        int danoReal = MATH.max(0, dano - defesa);
        vida = vida - danoReal;
    }

    
    //int posicao [2]; ?
    private int vida;
    private final int defesaInicial;
    private int defesa;
    private int ataque;
    private int alcance;
    private boolean habilidade_disponivel; // guerreiro só pode usar uma vez
    private final char aparencia;
    private int x;
    private int y;
    private final String classe;
 
    
}






