public interface WithdrawRepository{

    void save(Withdraw withdraw) throws CreditNotEnoughException;
}
