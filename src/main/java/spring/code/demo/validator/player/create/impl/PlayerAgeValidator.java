package spring.code.demo.validator.player.create.impl;

import org.springframework.stereotype.Component;
import spring.code.demo.exception.player.PlayerAgeException;
import spring.code.demo.model.Player;
import spring.code.demo.validator.player.create.PlayerCreateValidator;

@Component
public class PlayerAgeValidator implements PlayerCreateValidator {

    @Override
    public void validate(Player player) {
        if(player.getAge() <= 0){
            throw  new PlayerAgeException("Age can't be less than 0!");
        }
    }
}
