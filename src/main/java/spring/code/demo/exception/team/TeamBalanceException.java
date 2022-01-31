package spring.code.demo.exception.team;

public class TeamBalanceException extends RuntimeException {
    public TeamBalanceException() {
    }

    public TeamBalanceException(String message) {
        super(message);
    }
}
