package ge.tsu.transaction.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(TransactionNotFoundException.class)
  public ResponseEntity<ApplicationError> handleTransactionNotFoundException(
      TransactionNotFoundException exception, WebRequest webRequest) {
    ApplicationError error = new ApplicationError();
    error.setCode(101);
    error.setMessage(exception.getMessage());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(UserAlreadyExistsException.class)
  public ResponseEntity<ApplicationError> handleUserAlreadyExistsException(
      UserAlreadyExistsException exception, WebRequest webRequest
  ) {
    ApplicationError error = new ApplicationError();
    error.setCode(409);
    error.setMessage(exception.getMessage());

    return new ResponseEntity<>(error, HttpStatus.ALREADY_REPORTED);
  }

  @ExceptionHandler(UserIsNotRegisteredException.class)
  public ResponseEntity<ApplicationError> handleUserIsNotRegisteredException(
      UserIsNotRegisteredException exception, WebRequest webRequest
  ) {
    ApplicationError error = new ApplicationError();
    error.setCode(101);
    error.setMessage(exception.getMessage());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
  @ExceptionHandler(UserNotLoggedInException.class)
  public ResponseEntity<ApplicationError> handleUserNotLoggedInException(
      UserIsNotRegisteredException exception, WebRequest webRequest
  ) {
    ApplicationError error = new ApplicationError();
    error.setCode(101);
    error.setMessage(exception.getMessage());

    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }
}
