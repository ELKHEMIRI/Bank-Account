import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void should_return_an_error_when_money_is_negative() {
        assertThrows(AmountNotValidException.class, () -> Money.of(-4));
    }
}