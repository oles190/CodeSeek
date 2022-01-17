package spring.code.demo.exception.player;

public class PlayerNotFoundException extends  RuntimeException{
    public PlayerNotFoundException() {
    }

    public PlayerNotFoundException(String message) {
        super(message);
    }
}
