package entities;

/**
 *
 * @author EmersonPC
 */
public class CheckingAccount extends Account{
    
    public CheckingAccount(Client client) {
        super(client);
    }
    
    @Override
    public void showExtract(){
        System.out.println( "----- Checking Account -----" );
        System.out.println( super.showInfo() );
    }
}
