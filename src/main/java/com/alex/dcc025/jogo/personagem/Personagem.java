package com.alex.dcc025.jogo.personagem;

public class Personagem 
{
    protected final int defesaInicial;
    protected final char aparencia;
    protected final String classe;

    protected int vida;
    protected int defesa;
    protected int ataque;
    protected int alcance;

    protected int x;
    protected int y;


    public Personagem(int x, int y, String classe, char aparencia, int defesaInicial)
    {
        this.x = x;
        this.y = y;
        this.classe = classe;
        this.aparencia = aparencia;
        this.defesaInicial = defesaInicial;
        this.defesa = this.defesaInicial;
        this.vida = 100;
    }
    
    public void atacar(Personagem alvo)
    {
        alvo.receberDano(ataque);
    }
    
    public void defender()
    {
        defesa = defesaInicial;
    }
    
    public void mover(int deltaX, int deltaY)
    {
        x = x + deltaX;
        y = y + deltaY;
    }
    
    public void setX(int x)
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
        return this.vida;
    }
    
    public void setAlcance(int alcance)
    {
        this.alcance = alcance;
    }
    public int getAlcance()
    {
        return this.alcance;
    }
 
    public void setAtaque(int ataque)
    {
        this.ataque = ataque;
    }

    public int getAtaque()
    {
        return this.ataque;
    }

    public char getAparencia()
    {
        return this.aparencia;
    }
    
    public String getClasse()
    {
        return this.classe;
    }

    public void receberDano(int dano)
    {
        int defesaPosAtaque = Math.max(0,defesa - dano);
        defesa = defesaPosAtaque;
        int danoReal = Math.max(0, dano - defesa);
        vida = vida - danoReal;
    }

    public void habilidadeEspecial() {
    }
 
    
}






