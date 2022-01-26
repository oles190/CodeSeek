package spring.code.demo.validator.player.create.impl;

import org.springframework.stereotype.Component;
import spring.code.demo.exception.player.PlayerLastNameException;
import spring.code.demo.model.Player;
import spring.code.demo.validator.player.create.PlayerCreateValidator;

@Component
public class PlayerLastNameValidator implements PlayerCreateValidator {


    @Override
    public void validate(Player player) {
        if(player.getLastName() == null || player.getLastName().isEmpty()){
            throw  new PlayerLastNameException("Surname can't be null or empty!");
        }
    }
}
