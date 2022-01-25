package entities;

/**
 *
 * @author EmersonPC
 */
public class JogoNBA {
    
    // Não permite times com o mesmo nome
    //private Set<Time> times = new HashSet<>();
    private Time timeCasa;
    private Time timeFora;
    private final String NOME_JOGO;
    
    public JogoNBA(String nome){
        this.NOME_JOGO = nome;
    }
    
    public void inserirJogo(Time timeCasa, Time timeFora){
        this.timeCasa = timeCasa;
        this.timeFora = timeFora;
    }
    
    public void mostrarJogo(){
        System.out.println("---- Campeonato " + NOME_JOGO + " ----");
        this.timeCasa.mostrarPlacar();
        this.timeFora.mostrarPlacar();
    }
}
