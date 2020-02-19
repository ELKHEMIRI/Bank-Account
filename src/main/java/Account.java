public class Account {

    private String accountNumber;

    private Account(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public static Account of(String accountNumber) {
        checkAccountNumber(accountNumber);
        return new Account(accountNumber);

    }

    private static void checkAccountNumber(String accountNumber) {
        if(accountNumber == null || accountNumber.isEmpty()) {
            throw new AccountNumberNotValidException();
        }
    }
}
