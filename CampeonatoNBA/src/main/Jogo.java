package main;

import entities.JogoNBA;
import entities.Time;

/**
 *
 * @author EmersonPC
 */
public class Jogo {
    
    public static void main(String[] args) {
        Time goldenState = new Time( "Golden State", 10, 4 );
        Time lakers = new Time( "Lakers", 15, 8 );
        
        JogoNBA jogo = new JogoNBA( "NBA" );
        jogo.inserirJogo( lakers, goldenState );
        jogo.mostrarJogo();
        
        lakers.doisPontos();
        lakers.doisPontos();
        lakers.umPonto();
        
        jogo.mostrarJogo();
        
        goldenState.tresPontos();
        goldenState.umPonto();
        lakers.umPonto();
        
        jogo.mostrarJogo();
    }
}
