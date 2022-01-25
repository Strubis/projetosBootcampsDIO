package entities;

/**
 *
 * @author EmersonPC
 */
public class SavingsAccount extends Account{
    
    public SavingsAccount(Client client) {
        super(client);
    }
    
    @Override
    public void showExtract(){
        System.out.println("----- Savings Account -----");
        System.out.println( super.showInfo() );
    }
}
