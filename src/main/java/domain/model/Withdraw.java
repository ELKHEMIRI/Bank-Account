package domain.model;

public class Withdraw {

    private Money money;

    private Account account;

    public Withdraw(Money money, Account account) {
        this.money = money;
        this.account = account;
    }

    public Account getAccount() {
        return account;
    }

    public Money getMoney() {
        return money;
    }
}
