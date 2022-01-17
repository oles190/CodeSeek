package spring.code.demo.exception.player;

public class PlayerNameException extends  RuntimeException{
    public PlayerNameException() {
    }

    public PlayerNameException(String message) {
        super(message);
    }
}
