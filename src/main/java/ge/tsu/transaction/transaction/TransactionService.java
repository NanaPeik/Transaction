package ge.tsu.transaction.transaction;

import java.util.List;

public interface TransactionService {

  void createTransaction(TransactionAdd transaction);

  List<TransactionView> getTransactions(TransactionForFilter transaction);

  TransactionView getTransactionById(Integer transactionId);

  void deleteTransaction(Integer transactionId);
}
