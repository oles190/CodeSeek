package spring.code.demo.exception.team;

public class TeamNameException extends RuntimeException{

    public TeamNameException() {
    }

    public TeamNameException(String message) {
        super(message);
    }
}
