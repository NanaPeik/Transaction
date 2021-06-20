package ge.tsu.transaction.transaction;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.HttpRequestHandler;
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

  @GetMapping("/transactions")
  public List<TransactionView> getTransactions(TransactionForFilter transactionFilter) {
    return transactionService.getTransactions(transactionFilter);
  }

  @PostMapping("/transaction")
  public void createTransaction(@RequestBody TransactionAdd transactionAdd) {
    transactionService.createTransaction(transactionAdd);
  }

  @GetMapping("/transactions/{transactionId}")
  public TransactionView getTransactionById(@PathVariable Integer transactionId) {
    return transactionService.getTransactionById(transactionId);
  }

  @DeleteMapping("/transactions/{transactionId}")
  public void deleteTransaction(@PathVariable Integer transactionId) {
    transactionService.deleteTransaction(transactionId);
  }

  @GetMapping("/send")
  public void exportToPdf(HttpServletResponse response, HttpServletRequest request) throws IOException, MessagingException {
    Cookie[] cookies = request.getCookies();
    if (cookies != null && cookies.length > 0) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("user_id") && cookie.getValue() != null) {

        }
      }
    }
//    response.setContentType("application/pdf");
//
//    String headerKey = "Content-Disposition";
//    String headerValue = "attachment; filename=transactions.pdf";
//    response.setHeader(headerKey, headerValue);
//
//    TransactionView transaction = new TransactionView();
//    transaction.setAmount(23.0);
//    transaction.setDocumentNumber("d111");
//    transaction.setReceiver("dads");
//    transaction.setPostDate(LocalDateTime.now());
//    transaction.setReceiverAccount("dasd");
//    transaction.setSender("ads");
//    transaction.setSenderAccount("dasdsd");
//    List<TransactionView> listUsers = new ArrayList<>();
////        transactionService.getTransactions(new TransactionForFilter());
//
//    listUsers.add(transaction);
//    TransactionPDFExporter exporter = new TransactionPDFExporter(listUsers);
//    exporter.export(response);
//    sendEmailWithAttachment("nana.feiqrishvili2014@gmail.com",
//      "",
//      "email subject",
//      "D:\\Downloads\\transactions.pdf");
  }

  private void sendEmailWithAttachment(String toEmail,
    String body,
    String subject,
    String attachment) throws MessagingException {
//
//    MimeMessage message = mailSender.createMimeMessage();
//
//    MimeMessageHelper messageHelper =
//      new MimeMessageHelper(message, true);
//    messageHelper.setFrom("nana.feiqrisvili2014@gmail.com");
//    messageHelper.setTo(toEmail);
//    messageHelper.setText(body);
//    messageHelper.setSubject(subject);
//
//    FileSystemResource fileSystem
//      = new FileSystemResource(new File(attachment));
//
//    messageHelper.addAttachment(fileSystem.getFilename(), fileSystem);
//    mailSender.send(message);
//    System.out.println("Mail send...");
  }
}
