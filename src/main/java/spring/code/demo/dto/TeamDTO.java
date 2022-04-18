package spring.code.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import spring.code.demo.model.Team;



@Data
@NoArgsConstructor
public class TeamDTO {

    private Long id;

    private String name;

    private Long balance;

    private String city;

    private String country;

    private int commission;

    public TeamDTO(Long id, String name, Long balance, String city, String country, int commission) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.city = city;
        this.country = country;
        this.commission = commission;
    }


    public TeamDTO(Team team) {
        this.id = team.getId();
        this.name = team.getName();
        this.balance = team.getBalance();
        this.city = team.getCity();
        this.country = team.getCountry();
        this.commission = team.getCommission();
    }


}
