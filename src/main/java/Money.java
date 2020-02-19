public class Money {

    private int amount;

    private Money(int amount) {
        this.amount = amount;
    }

    public static Money of(int amount) {
        checkAmount(amount);
        return new Money(amount);

    }

    private static void checkAmount(int amount) {
        if(amount <= 0) {
            throw new AmountNotValidException();
        }
    }
}
