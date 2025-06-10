/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.jogo;

/**
 *
 * @author rachi
 */
public class PersonagemGuerreiro extends Personagem
{
     public PersonagemGuerreiro(int x, int y, String nome)
    {
        super('G', "Guerreiro", 10 )
        setAtaque(15);
        setAlcance(1);
        setDefesa(10); 
        setX(x);
        setY(y);
        setNome(nome);
        habilidadeDisponivel = true; // guerreiro so usa uma vez
    }
     
    public void habilidadeEspecial()
    {
        if(habilidadeDisponivel)
        {
           ataque = ataque*2;
           habilidadeDisponivel = false;
        }
    }
    
    private boolean habilidadeDisponivel;
}
