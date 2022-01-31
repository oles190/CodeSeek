package spring.code.demo.exception.team;

public class TeamCountryException extends RuntimeException {

    public TeamCountryException() {
    }

    public TeamCountryException(String message) {
        super(message);
    }
}
