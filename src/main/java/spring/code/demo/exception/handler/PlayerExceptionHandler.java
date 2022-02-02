package spring.code.demo.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import spring.code.demo.exception.player.*;

@ControllerAdvice
public class PlayerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(PlayerAgeException.class)
    public ResponseEntity<ErrorMessage> handleException(PlayerAgeException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PlayerLastNameException.class)
    public ResponseEntity<ErrorMessage> handleException(PlayerLastNameException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PlayerNameException.class)
    public ResponseEntity<ErrorMessage> handleException(PlayerNameException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PlayerExperienceException.class)
    public ResponseEntity<ErrorMessage> handleException(PlayerExperienceException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

}

