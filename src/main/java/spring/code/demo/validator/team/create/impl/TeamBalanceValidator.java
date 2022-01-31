package spring.code.demo.validator.team.create.impl;

import org.springframework.stereotype.Component;
import spring.code.demo.exception.team.TeamBalanceException;
import spring.code.demo.model.Team;
import spring.code.demo.validator.team.create.TeamCreateValidator;

@Component
public class TeamBalanceValidator implements TeamCreateValidator {

    @Override
    public void validate(Team team) {
        if (team.getBalance() == null || team.getBalance() < 0) {

            throw new TeamBalanceException("Balance can't be null or less than 0!");
        }
    }
}
