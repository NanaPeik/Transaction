package ge.tsu.transaction;

public class TransactionAdd {
  private String sender;
  private String senderAccount;
  private String receiver;
  private String receiverAccount;
  private Float amount;
//  private String documentNumber;
//  private String postDate;


  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getSenderAccount() {
    return senderAccount;
  }

  public void setSenderAccount(String senderAccount) {
    this.senderAccount = senderAccount;
  }

  public String getReceiver() {
    return receiver;
  }

  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }

  public String getReceiverAccount() {
    return receiverAccount;
  }

  public void setReceiverAccount(String receiverAccount) {
    this.receiverAccount = receiverAccount;
  }

  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }
}
