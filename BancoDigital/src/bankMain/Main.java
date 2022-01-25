package bankMain;

import entities.Account;
import entities.Bank;
import entities.CheckingAccount;
import entities.Client;
import entities.SavingsAccount;

/**
 *
 * @author EmersonPC
 */
public class Main {

    public static void main(String[] args) {
        Client lucas = new Client( "Lucas" );
        Client max = new Client( "Max" );

        Account ca = new CheckingAccount( lucas );
        Account sa = new SavingsAccount( max );

        ca.deposit( 154.12 );
        ca.transfer( 100, sa );

        ca.showExtract();
        sa.showExtract();
        
        Bank bank = new Bank( "BN" );
        bank.setClients( lucas );
        bank.setClients( max );
        bank.setAccounts( ca );
        bank.setAccounts( sa );
        
        bank.showInfo();
    }
}
