package domain.model;

import domain.model.Account;
import domain.model.Money;

import java.util.Optional;

public interface BalanceRepository {

    Optional<Money> findBalance(Account account);


}
