package spring.code.demo.exception.player;

public class PlayerAgeException extends RuntimeException{
    public PlayerAgeException() {
    }

    public PlayerAgeException(String message) {
        super(message);
    }
}
