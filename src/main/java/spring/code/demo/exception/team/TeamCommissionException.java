package spring.code.demo.exception.team;

public class TeamCommissionException extends RuntimeException {

    public TeamCommissionException() {
    }

    public TeamCommissionException(String message) {
        super(message);
    }
}
