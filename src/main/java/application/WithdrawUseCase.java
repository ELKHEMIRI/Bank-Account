package application;

import domain.model.Withdraw;
import domain.model.WithdrawRepository;

public class WithdrawUseCase {

    private WithdrawRepository withdrawRepository;

    public WithdrawUseCase(WithdrawRepository withdrawRepository) {
        this.withdrawRepository = withdrawRepository;
    }

    public void save(Withdraw withdraw) {
        withdrawRepository.save(withdraw);

    }
}
