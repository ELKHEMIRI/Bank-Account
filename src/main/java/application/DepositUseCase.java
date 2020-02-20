package application;

import domain.model.Deposit;
import domain.model.DepositRepository;

public class DepositUseCase {

    private DepositRepository depositRepository;

    public DepositUseCase(DepositRepository depositRepository) {
        this.depositRepository = depositRepository;
    }

    public void save(Deposit deposit) {
        depositRepository.save(deposit);

    }
}
