package ge.tsu.transaction.exception;

public class UserNotFoundException extends RuntimeException{

  public UserNotFoundException(String message){
    super(message);
  }
}
