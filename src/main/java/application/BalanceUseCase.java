package application;

import domain.model.Account;
import domain.model.AccountNotFoundException;
import domain.model.BalanceRepository;
import domain.model.Money;

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
