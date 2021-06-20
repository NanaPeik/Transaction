package ge.tsu.transaction.exception;

public class UserNotLoggedInException extends RuntimeException {

  public UserNotLoggedInException(String message) {
    super(message);
  }
}
