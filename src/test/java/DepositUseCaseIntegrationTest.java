import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepositUseCaseIntegrationTest {

    private DepositUseCase depositUseCase;
    private BalanceUseCase balanceUseCase;

    @BeforeEach
    void setUp() {
        Map<Account, Money> credits = new HashMap<>();
        InMemoryRepository repository = new InMemoryRepository(credits);
        depositUseCase = new DepositUseCase(repository);
        balanceUseCase = new BalanceUseCase(repository);
    }

    @Test
    void should_credit_account_after_making_some_deposits() {
        // Arrange
        String accountNumber = "123456";
        Account account = Account.of(accountNumber);
        Deposit firstDeposit = new Deposit(Money.of(400), account);
        Deposit secondDeposit = new Deposit(Money.of(300), account);
        Deposit thirdDeposit = new Deposit(Money.of(1400), account);

        // Act
        depositUseCase.save(firstDeposit);
        depositUseCase.save(secondDeposit);
        depositUseCase.save(thirdDeposit);
        Money credit = balanceUseCase.getBalance(account);

        // Assert
        assertEquals(Money.of(2100), credit);
    }

    @Test
    void should_not_interfere_when_making_deposits_on_different_accounts() {
        // Arrange
        String accountNumber1 = "123456";
        Account account1 = Account.of(accountNumber1);

        String accountNumber2 = "654321";
        Account account2 = Account.of(accountNumber2);

        Deposit depositOnAccount1 = new Deposit(Money.of(400), account1);
        Deposit depositOnAccount2 = new Deposit(Money.of(1400), account2);

        // Act
        depositUseCase.save(depositOnAccount1);
        depositUseCase.save(depositOnAccount2);
        Money creditAccount1 = balanceUseCase.getBalance(account1);
        Money creditAccount2 = balanceUseCase.getBalance(account2);

        // Assert
        assertEquals(Money.of(400), creditAccount1);
        assertEquals(Money.of(1400), creditAccount2);

    }

}
