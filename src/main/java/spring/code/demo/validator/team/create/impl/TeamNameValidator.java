package spring.code.demo.validator.team.create.impl;

import org.springframework.stereotype.Component;
import spring.code.demo.exception.team.TeamNameException;
import spring.code.demo.model.Team;
import spring.code.demo.validator.team.create.TeamCreateValidator;

@Component
public class TeamNameValidator implements TeamCreateValidator {

    @Override
    public void validate(Team team) {
        if(team.getName() == null || team.getName().isEmpty()){
            throw new TeamNameException("Name can't be null or empty!");
        }
    }
}
