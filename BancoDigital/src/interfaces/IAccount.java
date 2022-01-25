package interfaces;

/**
 *
 * @author EmersonPC
 */
public interface IAccount {

    void takeMoney(double valor);

    void deposit(double valor);

    void transfer(double valor, IAccount contaDestino);

    void showExtract();
}
