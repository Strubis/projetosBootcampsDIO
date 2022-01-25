package entities;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author EmersonPC
 */
public class Bank {

    private String name;
    private List<Account> accounts = new ArrayList<>();
    private List<Client> clients = new ArrayList<>();

    public Bank(String name){
        this.name = name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAccounts(Account account) {
        this.accounts.add( account );
    }

    public void setClients(Client client) {
        this.clients.add( client );
    }
    
    public void showInfo(){
        System.out.println("\n==== Bank " + name + " ====");
        System.out.println("---- Accounts ----");
        accounts.forEach( 
                i -> System.out.println( "\tAccount{ \n" + i.showInfo() + "\n\t}" ) 
        );
        
        System.out.println("---- Clients ----");
        clients.forEach( 
                i -> System.out.println( "\tClient{ \n\t\t" + i.getName() + "\n\t}" ) 
        );
    }
    
}
