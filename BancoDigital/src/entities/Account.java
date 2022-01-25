package entities;

import errors.NoHaveMoneyToTake;
import interfaces.IAccount;

/**
 *
 * @author EmersonPC
 */
public abstract class Account implements IAccount {

    private static final int DEFAULT_AGENCY = 1;
    private static int SEQ = 1;

    protected int agency;
    protected int number;
    protected double amount;
    protected Client client;

    public Account(Client client) {
        this.agency = Account.DEFAULT_AGENCY;
        this.number = SEQ++;
        this.client = client;
    }

    public boolean verifyIfCanTakeMoney(double value) {
        return value <= amount;
    }
    
    @Override
    public void takeMoney(double value) {

        if (verifyIfCanTakeMoney(value))
            amount -= value;
        else
            throw new NoHaveMoneyToTake();
        
    }

    @Override
    public void deposit(double value) {
        amount += value;
    }

    @Override
    public void transfer(double value, IAccount destAccount) {
        this.takeMoney( value );
        destAccount.deposit( value );
    }

    public int getAgency() {
        return agency;
    }

    public int getNumber() {
        return number;
    }

    public double getAmount() {
        return amount;
    }

    public Client getClients() {
        return client;
    }
    
    protected String showInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append( String.
                format("\t\tOwner: %s", this.client.getName()) );
	
	sb.append( String.
                format("\n\t\tAgency: %d", this.agency) );
	sb.append( String.
                format("\n\t\tNumber: %d", this.number) );
	sb.append( String.
                format("\n\t\tAmount: %.2f", this.amount) );
        
        return sb.toString();
    }
    
}
