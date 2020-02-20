import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BalanceUseCaseTest {

    private BalanceUseCase balanceUseCase;
    private BalanceRepository balanceRepository;

    @BeforeEach
    void setUp() {
        balanceRepository = mock(BalanceRepository.class);
        balanceUseCase = new BalanceUseCase(balanceRepository);

    }

    @Test
    void should_return_money_of_account() {
        // Arrange
        String accountNumber = "345876";
        Account account = Account.of(accountNumber);
        when(balanceRepository.findBalance(eq(account)))
                .thenReturn(Money.of(2000));

        // Act
        Money credit = balanceUseCase.getBalance(account);

        // Assert
        assertEquals(Money.of(2000), credit);
    }
}
