
public class BalanceUseCase {

    private BalanceRepository balanceRepository;

    public BalanceUseCase(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public Money getBalance(Account account) throws AccountNotFoundException {
        return balanceRepository.findBalance(account)
                .orElseThrow(AccountNotFoundException::new);
    }
}
