package ge.tsu.transaction;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

  @Autowired
  TransactionService transactionService;

  @GetMapping("/transactions")
  public List<Transaction> getTransactions(
      @RequestBody TransactionForFilter transaction) {
    return transactionService.getTransactions(transaction);
  }

  @PostMapping("/transaction")
  public void createTransaction(
      @RequestBody TransactionAdd transactionAdd) {
    transactionService.createTransaction(transactionAdd);
  }

  @GetMapping("/transactions/{transactionId}")
  public Transaction getTransactionById(
      @PathVariable String transactionId) {
    return transactionService.getTransactionById(transactionId);
  }

  @DeleteMapping("/transactions/{transactionId}")
  public void deleteTransaction(
      @PathVariable String transactionId) {
    transactionService.deleteTransaction(transactionId);
  }
}
