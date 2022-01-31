package spring.code.demo.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import spring.code.demo.exception.team.*;


@ControllerAdvice
public class TeamExceptionHandler extends ResponseEntityExceptionHandler {



    @ExceptionHandler(TeamNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleException(TeamNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TeamBalanceException.class)
    public ResponseEntity<ErrorMessage> handleException(TeamBalanceException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TeamCityException.class)
    public ResponseEntity<ErrorMessage> handleException(TeamCityException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TeamCommissionException.class)
    public ResponseEntity<ErrorMessage> handleException(TeamCommissionException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TeamCountryException.class)
    public ResponseEntity<ErrorMessage> handleException(TeamCountryException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TeamNameException.class)
    public ResponseEntity<ErrorMessage> handleException(TeamNameException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }






}
