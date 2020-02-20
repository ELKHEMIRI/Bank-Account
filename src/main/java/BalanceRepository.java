import java.util.Optional;

public interface BalanceRepository {

    Optional<Money> findBalance(Account account);


}
