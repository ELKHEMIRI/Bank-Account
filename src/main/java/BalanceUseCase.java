public class BalanceUseCase {

    private BalanceRepository balanceRepository;

    public BalanceUseCase(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public Money getBalance(Account account) {
        return balanceRepository.findBalance(account);
    }
}
