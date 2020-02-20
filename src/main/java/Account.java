import java.util.Objects;

public class Account {

    private String accountNumber;

    private Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static Account of(String accountNumber) {
        checkAccountNumber(accountNumber);
        return new Account(accountNumber);

    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Account account = (Account) object;
        return accountNumber.equals(account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber);
    }

    private static void checkAccountNumber(String accountNumber) {
        if(accountNumber == null || accountNumber.isEmpty()) {
            throw new AccountNotValidException();
        }
    }

}
