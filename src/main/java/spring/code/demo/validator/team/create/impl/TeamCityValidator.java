package spring.code.demo.validator.team.create.impl;

import org.springframework.stereotype.Component;
import spring.code.demo.exception.team.TeamCityException;
import spring.code.demo.model.Team;
import spring.code.demo.validator.team.create.TeamCreateValidator;

@Component
public class TeamCityValidator implements TeamCreateValidator {

    @Override
    public void validate(Team team) {

        if (team.getCity() == null || team.getCity().isEmpty()) {

            throw new TeamCityException("City can't be null or empty");
        }

    }
}
