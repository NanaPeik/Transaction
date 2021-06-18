package ge.tsu.transaction;

import java.util.List;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionServiceImpl implements TransactionService{

  @Autowired
  private DSLContext dslContext;

  @Override
  public boolean createTransaction(TransactionAdd transaction) {

    return false;
  }

  @Override
  public List<Transaction> getTransactions(Transaction transaction) {
    return null;
  }

  @Override
  public Transaction getTransactionById(String documentNumber) {
    return null;
  }

  @Override
  public boolean deleteTransaction(String documentNumber) {
    return false;
  }
}
