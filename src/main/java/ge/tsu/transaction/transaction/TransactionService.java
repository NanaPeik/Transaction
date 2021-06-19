package ge.tsu.transaction.transaction;

import java.util.List;

public interface TransactionService {
    void createTransaction(TransactionAdd transaction);
    List<Transaction> getTransactions(TransactionForFilter transaction);
    Transaction getTransactionById(String documentNumber);
    void deleteTransaction(String documentNumber);
}
