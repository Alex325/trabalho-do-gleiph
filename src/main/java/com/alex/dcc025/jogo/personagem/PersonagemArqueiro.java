/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.jogo;

/**
 *
 * @author rachi
 */
public class PersonagemArqueiro extends Personagem
{
    public PersonagemArqueiro(int x, int y, String nome)
    {
        super( 'A', "Arqueiro", 5);
        setAtaque(8);
        setAlcance(5);
        setDefesa(5);   
        setX(x);
        setY(y);
        setNome(nome);
    }
    
    public void habilidadeEspecial()
    {
        alcance++;
    }
}
