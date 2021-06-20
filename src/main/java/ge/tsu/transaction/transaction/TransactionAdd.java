package ge.tsu.transaction.transaction;

import java.time.LocalDateTime;

public class TransactionAdd {

  private LocalDateTime postDate;
  private Double amount;
  private Integer receiverId;
  private Integer senderId;

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
}
