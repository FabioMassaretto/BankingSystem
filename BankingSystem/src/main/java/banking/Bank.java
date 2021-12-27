package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;

    public Bank() {
        accounts = new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {

        return accounts.get(accountNumber);
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        Long accountNumber = accounts.size() + 1L;

        Account acc = new CommercialAccount(company, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, acc);
        return accountNumber;
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
        Long accountNumber = accounts.size() + 1L;

        Account acc = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
        accounts.put(accountNumber, acc);
        return accountNumber;
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        Account account = getAccount(accountNumber);
        return account.validatePin(pin);
    }

    public double getBalance(Long accountNumber) {
        Account account = getAccount(accountNumber);
        return account.getBalance();
    }

    public void credit(Long accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        account.creditAccount(amount);
    }

    public boolean debit(Long accountNumber, double amount) {
        return getAccount(accountNumber).debitAccount(amount);
    }
}
