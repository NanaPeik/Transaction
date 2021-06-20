package ge.tsu.transaction.transaction;

import ge.tsu.transaction.user.UserView;
import java.time.LocalDateTime;

public class TransactionView {

  private Integer id;
  private String documentNumber;
  private LocalDateTime postDate;
  private Double amount;
  private Integer receiverId;
  private UserView receiver;
  private Integer senderId;
  private UserView sender;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  public LocalDateTime getPostDate() {
    return postDate;
  }

  public void setPostDate(LocalDateTime postDate) {
    this.postDate = postDate;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Integer getReceiverId() {
    return receiverId;
  }

  public void setReceiverId(Integer receiverId) {
    this.receiverId = receiverId;
  }

  public Integer getSenderId() {
    return senderId;
  }

  public void setSenderId(Integer senderId) {
    this.senderId = senderId;
  }

  public UserView getReceiver() {
    return receiver;
  }

  public void setReceiver(UserView receiver) {
    this.receiver = receiver;
  }

  public UserView getSender() {
    return sender;
  }

  public void setSender(UserView sender) {
    this.sender = sender;
  }
}
