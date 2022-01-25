package errors;

/**
 *
 * @author EmersonPC
 */
public class NoHaveMoneyToTake extends RuntimeException{
    
    public NoHaveMoneyToTake(){
        super( "You don't have enough money!" );
    }
    
}
