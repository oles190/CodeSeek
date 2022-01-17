package spring.code.demo.validator.team.create.impl;

import org.springframework.stereotype.Component;
import spring.code.demo.exception.team.TeamCountryException;
import spring.code.demo.model.Team;
import spring.code.demo.validator.team.create.TeamCreateValidator;

@Component
public class TeamCountryValidator implements TeamCreateValidator {
    @Override
    public void validate(Team team) {
        if(team.getCountry()==null || team.getCountry().isEmpty()){
            throw new TeamCountryException("Country can't be null or empty!");
        }

    }
}
