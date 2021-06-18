package ge.tsu.transaction;

import java.util.List;

public interface TransactionService {
    void createTransaction(TransactionAdd transaction);
    List<Transaction> getTransactions(TransactionForFilter transaction);
    Transaction getTransactionById(String documentNumber);
    boolean deleteTransaction(String documentNumber);
}
