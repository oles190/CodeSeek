package spring.code.demo.validator.player.create.impl;


import org.springframework.stereotype.Component;
import spring.code.demo.exception.player.PlayerExperienceException;
import spring.code.demo.model.Player;
import spring.code.demo.validator.player.create.PlayerCreateValidator;

@Component
public class PlayerExperienceValidator implements PlayerCreateValidator {

    @Override
    public void validate(Player player) {

        if(player.getExperience() < 0){
            throw  new PlayerExperienceException("Experience can't be less than 0!");
        }
    }
}
