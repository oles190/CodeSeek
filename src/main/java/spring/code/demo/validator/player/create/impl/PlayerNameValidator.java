package spring.code.demo.validator.player.create.impl;

import org.springframework.stereotype.Component;
import spring.code.demo.exception.player.PlayerNameException;
import spring.code.demo.model.Player;
import spring.code.demo.validator.player.create.PlayerCreateValidator;


@Component
public class PlayerNameValidator implements PlayerCreateValidator {


    @Override
    public void validate(Player player) {
        if(player.getName()==null || player.getName().isEmpty()){
         throw new PlayerNameException("Name can't be null");
        }
    }
}
