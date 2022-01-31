package spring.code.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import spring.code.demo.model.Team;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
public class TeamDTO {

    private Long id;

    private String name;

    private Long balance;

    private String city;

    private String country;


    private int commission;

    public TeamDTO(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.balance = team.getBalance();
        this.city = team.getCity();
        this.country = team.getCountry();
        this.commission = team.getCommission();
    }
}
