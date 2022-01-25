package entities;

import interfaces.ITime;

/**
 *
 * @author EmersonPC
 */
public class Time implements ITime{
    
    protected String nome;
    protected int qtdJogadores;
    protected int qtdTitulos;
    protected int pontos = 0;
    
    public Time(String nome, int qtdJogadores, int qtdTitulos){
        this.nome = nome;
        this.qtdJogadores = qtdJogadores;
        this.qtdTitulos = qtdTitulos;
    }

    @Override
    public void tresPontos(){
        this.pontos += 3;
    }
    
    @Override
    public void doisPontos(){
        this.pontos += 2;
    }
    
    @Override
    public void umPonto(){
        this.pontos++;
    }
    
    @Override
    public void mostrarPlacar(){
        System.out.println( this.nome + " - " + this.pontos + " pontos" );
    }
}
