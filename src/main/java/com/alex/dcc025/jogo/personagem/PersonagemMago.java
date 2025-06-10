/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.ufjf.jogo;

/**
 *
 * @author rachi
 */
public class PersonagemMago extends Personagem
{
    public PersonagemMago(int x, int y, String nome)
    {
        super( 'M', "Mago", 7);
        setAtaque(10);
        setAlcance(3);
        setDefesa(7); 
        setX(x);
        setY(y);
        setNome(nome);
    }
    
    public void habilidadeEspecial( Personagem Alvo)
    {
        int VariavelTemporaria = vida;
        vida = Alvo.getVida();
        Alvo.setVida(VariavelTemporaria);
    }
}
