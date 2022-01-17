package spring.code.demo.exception.team;

public class TeamCityException extends  RuntimeException
{
    public TeamCityException() {
    }

    public TeamCityException(String message) {
        super(message);
    }
}
