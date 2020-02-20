import java.util.Map;
import java.util.Optional;

class InMemoryRepository implements DepositRepository, BalanceRepository, WithdrawRepository {

    private Map<Account, Money> credits;

    public InMemoryRepository(Map<Account, Money> credits) {
        this.credits = credits;
    }

    @Override
    public void save(Deposit deposit) {
        Account account = deposit.getAccount();
        Money money = deposit.getMoney();
        if (credits.containsKey(account)) {
            credits.get(account).add(money);
            return;
        }
        credits.put(account, money);
    }

    @Override
    public Optional<Money> findBalance(Account account) {
        return Optional.ofNullable(credits.get(account));
    }

    @Override
    public void save(Withdraw withdraw) throws CreditNotEnoughException {
        try{
            credits.get(withdraw.getAccount())
                    .substract(withdraw.getMoney());
        } catch(AmountNotValidException e) {
            throw new CreditNotEnoughException();
        }

    }
}