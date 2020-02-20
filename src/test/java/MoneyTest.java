import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void should_return_an_error_when_money_is_negative() {
        assertThrows(AmountNotValidException.class, () -> Money.of(-4));
    }

    @Test
    void should_be_equal_when_two_money_have_the_same_amount() {
        // Arrange
        Money money1 = Money.of(10);
        Money money2 = Money.of(10);

        // Assert
        assertEquals(money1, money2);
    }

    @Test
    void should_not_be_equal_when_two_money_have_different_amounts() {
        // Arrange
        Money money1 = Money.of(12);
        Money money2 = Money.of(14);

        // Assert
        assertNotEquals(money1, money2);
    }
}