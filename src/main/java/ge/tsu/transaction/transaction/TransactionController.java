package ge.tsu.transaction.transaction;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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
  @Autowired
  private JavaMailSender mailSender;

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
  public void exportToPdf(HttpServletResponse response) throws IOException, MessagingException {

    response.setContentType("application/pdf");

    String headerKey = "Content-Disposition";
    String headerValue = "attachment; filename=transactions.pdf";
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
    sendEmailWithAttachment("nana.feiqrishvili2014@gmail.com",
        "",
        "email subject",
        "D:\\Downloads\\transactions.pdf");
  }

  private void sendEmailWithAttachment(String toEmail,
      String body,
      String subject,
      String attachment) throws MessagingException {

    MimeMessage message = mailSender.createMimeMessage();

    MimeMessageHelper messageHelper =
        new MimeMessageHelper(message, true);
    messageHelper.setFrom("nana.feiqrisvili2014@gmail.com");
    messageHelper.setTo(toEmail);
    messageHelper.setText(body);
    messageHelper.setSubject(subject);

    FileSystemResource fileSystem
        = new FileSystemResource(new File(attachment));

    messageHelper.addAttachment(fileSystem.getFilename(),fileSystem);
    mailSender.send(message);
    System.out.println("Mail send...");
  }
}
