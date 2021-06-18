package ge.tsu.transaction;

import java.util.List;

public interface TransactionService {
    boolean createTransaction(TransactionAdd transaction);
    List<Transaction> getTransactions(Transaction transaction);
    Transaction getTransactionById(String documentNumber);
    boolean deleteTransaction(String documentNumber);
}
