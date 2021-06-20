package ge.tsu.transaction.exception;

public class HaveNotEnoughAmountForTransactionException extends RuntimeException{

  public HaveNotEnoughAmountForTransactionException(String message) {
    super(message);
  }
}
