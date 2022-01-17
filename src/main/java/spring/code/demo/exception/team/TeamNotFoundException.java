package spring.code.demo.exception.team;

public class TeamNotFoundException extends RuntimeException{

    public TeamNotFoundException() {
    }

    public TeamNotFoundException(String message) {
        super(message);
    }

    public TeamNotFoundException(Throwable cause) {
        super(cause);
    }
}
