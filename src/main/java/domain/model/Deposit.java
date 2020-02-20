package domain.model;

public class Deposit {

    private Money money;

    private Account account;

    public Deposit(Money money, Account account) {
        this.money = money;
        this.account = account;
    }

    public Money getMoney() {
        return money;
    }

    public Account getAccount() {
        return account;
    }
}
