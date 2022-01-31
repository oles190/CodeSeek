package spring.code.demo.validator.team.create.impl;

import org.springframework.stereotype.Component;
import spring.code.demo.exception.team.TeamCommissionException;
import spring.code.demo.model.Team;
import spring.code.demo.validator.team.create.TeamCreateValidator;

@Component
public class TeamCommissionValidator implements TeamCreateValidator {
    @Override
    public void validate(Team team) {

        if (team.getCommission() < 0 || team.getCommission() > 10) {

            throw new TeamCommissionException("Commission can't be less than 0 or more than 10");
        }

    }
}
