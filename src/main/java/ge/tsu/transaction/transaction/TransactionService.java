package ge.tsu.transaction.transaction;

import ge.tsu.transaction.transaction.Transaction;
import ge.tsu.transaction.transaction.TransactionAdd;
import ge.tsu.transaction.transaction.TransactionForFilter;
import java.util.List;

public interface TransactionService {
    void createTransaction(TransactionAdd transaction);
    List<Transaction> getTransactions(TransactionForFilter transaction);
    Transaction getTransactionById(String documentNumber);
    void deleteTransaction(String documentNumber);
}
