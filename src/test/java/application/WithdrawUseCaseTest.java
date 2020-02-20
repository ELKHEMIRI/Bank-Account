package application;

import application.WithdrawUseCase;
import domain.model.Account;
import domain.model.Money;
import domain.model.Withdraw;
import domain.model.WithdrawRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WithdrawUseCaseTest {

    private WithdrawUseCase withdrawUseCase;

    private WithdrawRepository withdrawRepository;

    @BeforeEach
    void setUp() {
        withdrawRepository = mock(WithdrawRepository.class);
        withdrawUseCase = new WithdrawUseCase(withdrawRepository);
    }

    @Test
    void should_withdraw_money() {
        // Arrange
        String accountNumber = "546779";
        Account account = Account.of(accountNumber);
        Money amount = Money.of(500);
        Withdraw withdraw = new Withdraw(amount, account);

        // Act
        withdrawUseCase.save(withdraw);

        // Assert
        verify(withdrawRepository).save(eq(withdraw));

    }
}
