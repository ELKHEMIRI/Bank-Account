package domain.model;

import domain.model.Withdraw;

public interface WithdrawRepository{

    void save(Withdraw withdraw) throws CreditNotEnoughException;
}
