import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WithdrawUseCaseIntegrationTest {

    private DepositUseCase depositUseCase;
    private BalanceUseCase balanceUseCase;
    private WithdrawUseCase withdrawUseCase;

    @BeforeEach
    void setUp() {
        Map<Account, Money> credits = new HashMap<>();
        InMemoryRepository repository = new InMemoryRepository(credits);
        depositUseCase = new DepositUseCase(repository);
        balanceUseCase = new BalanceUseCase(repository);
        withdrawUseCase = new WithdrawUseCase(repository);
    }

    @Test
    void should_withdraw_after_making_some_deposit() {
        // Arrange
        String accountNumber = "3457892";
        Account account = Account.of(accountNumber);
        Money firstDeposit = Money.of(400);
        Money secondDeposit = Money.of(600);
        Money withdraw = Money.of(100);
        depositUseCase.save(new Deposit(firstDeposit, account));
        depositUseCase.save(new Deposit(secondDeposit, account));

        // Act
        withdrawUseCase.save(new Withdraw(withdraw, account));

        // Assert
        Money credit = balanceUseCase.getBalance(account);
        assertEquals(Money.of(900), credit);
    }

    @Test
    void should_return_an_error_when_credit_is_not_enough() {
        // Arrange
        String accountNumber = "3457892";
        Account account = Account.of(accountNumber);
        Money deposit = Money.of(400);
        Money withdraw = Money.of(1500);
        depositUseCase.save(new Deposit(deposit, account));

        // Assert
        assertThrows(CreditNotEnoughException.class, () -> withdrawUseCase.save(new Withdraw(withdraw, account)));
    }


}
