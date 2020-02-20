import java.util.Objects;

public class Money {

    private int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money of(int amount) {
        checkAmount(amount);
        return new Money(amount);

    }

    public void add(Money money) {
        amount += money.amount;
    }

    public void substract(Money money) {
        checkAmount(amount - money.amount);
        amount -= money.amount;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Money money = (Money) object;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    private static void checkAmount(int amount) {
        if (amount < 0) {
            throw new AmountNotValidException();
        }
    }
}
