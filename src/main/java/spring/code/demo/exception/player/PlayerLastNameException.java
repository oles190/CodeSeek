package spring.code.demo.exception.player;

public class PlayerLastNameException extends RuntimeException {

    public PlayerLastNameException() {
    }

    public PlayerLastNameException(String message) {
        super(message);
    }
}
