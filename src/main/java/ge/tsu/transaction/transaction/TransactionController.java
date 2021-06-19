package ge.tsu.transaction.transaction;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

  @PostMapping("/transactions")
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

  @GetMapping("/send")
  public void exportToPdf(HttpServletResponse response) throws IOException {

    response.setContentType("application/pdf");

    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename=users_1.pdf";
    response.setHeader(headerKey, headerValue);

    Transaction transaction=new Transaction();
    transaction.setAmount(23.0);
    transaction.setDocumentNumber("d111");
    transaction.setReceiver("dads");
    transaction.setPostDate(LocalDateTime.now());
    transaction.setReceiverAccount("dasd");
    transaction.setSender("ads");
    transaction.setSenderAccount("dasdsd");
    List<Transaction> listUsers = new ArrayList<>();
//        transactionService.getTransactions(new TransactionForFilter());

    listUsers.add(transaction);
    TransactionPDFExporter exporter = new TransactionPDFExporter(listUsers);
    exporter.export(response);
  }
}
