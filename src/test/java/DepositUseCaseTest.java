import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DepositUseCaseTest {


    private DepositUseCase depositUseCase;
    private DepositRepository depositRepository;

    @BeforeEach
    void setUp() {
        depositRepository = mock(DepositRepository.class);
        depositUseCase = new DepositUseCase(depositRepository);
    }

    @Test
    void should_deposit_money_on_account() {
        // Arrange
        int amount = 100;
        String accountNumber = "932156";
        Deposit deposit = new Deposit(Money.of(amount), Account.of(accountNumber));

        // Act
        depositUseCase.save(deposit);

        // Assert
        verify(depositRepository).save(eq(deposit));
    }
}
