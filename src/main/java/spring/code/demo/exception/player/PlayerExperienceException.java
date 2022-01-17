package spring.code.demo.exception.player;

public class PlayerExperienceException extends RuntimeException{

    public PlayerExperienceException() {
    }

    public PlayerExperienceException(String message) {
        super(message);
    }
}
