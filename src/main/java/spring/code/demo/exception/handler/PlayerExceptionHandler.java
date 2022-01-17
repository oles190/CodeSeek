package spring.code.demo.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import spring.code.demo.exception.player.*;
import spring.code.demo.exception.team.*;

@ControllerAdvice
public class PlayerExceptionHandler extends ResponseEntityExceptionHandler  {



        @org.springframework.web.bind.annotation.ExceptionHandler (value = PlayerAgeException.class)
        protected ResponseEntity handle(PlayerAgeException ex) {
            return new ResponseEntity<>(ex.getMessage() , HttpStatus.BAD_REQUEST);
        }

        @org.springframework.web.bind.annotation.ExceptionHandler (value = PlayerExperienceException.class)
        protected ResponseEntity handle(PlayerExperienceException ex) {
            return new ResponseEntity<>(ex.getMessage() , HttpStatus.BAD_REQUEST);
        }

        @org.springframework.web.bind.annotation.ExceptionHandler (value = PlayerLastNameException.class)
        protected ResponseEntity handle(PlayerLastNameException ex) {
            return new ResponseEntity<>(ex.getMessage() , HttpStatus.BAD_REQUEST);
        }
        @org.springframework.web.bind.annotation.ExceptionHandler (value = TeamCommissionException.class)
        protected ResponseEntity handle(TeamCommissionException ex) {
            return new ResponseEntity<>(ex.getMessage() , HttpStatus.BAD_REQUEST);
        }
        @org.springframework.web.bind.annotation.ExceptionHandler (value = PlayerNameException.class)
        protected ResponseEntity handle(PlayerNameException ex) {
            return new ResponseEntity<>(ex.getMessage() , HttpStatus.BAD_REQUEST);
        }

    @org.springframework.web.bind.annotation.ExceptionHandler (value = PlayerNotFoundException.class)
    protected ResponseEntity handle(PlayerNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage() , HttpStatus.NOT_FOUND);
    }



}

