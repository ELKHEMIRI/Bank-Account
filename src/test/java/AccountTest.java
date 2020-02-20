import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class AccountTest {

    @Test
    void should_return_an_error_when_account_number_is_null() {
        // Assert
        assertThrows(AccountNotValidException.class, () -> Account.of(null));
    }

    @Test
    void should_return_an_error_when_account_number_is_empty() {
        // Assert
        assertThrows(AccountNotValidException.class, () -> Account.of(""));
    }
}