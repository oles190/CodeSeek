package spring.code.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import spring.code.demo.model.Player;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class PlayerDTO {



    private Long id;

    private String name;

    private String lastName;

    private int age;

    private int experience;

    private TeamDTO teamDTO;

    private LocalDate startCareer;


    public PlayerDTO(Player player) {
        this.id = player.getId();
        this.name = player.getName();
        this.lastName = player.getLastName();
        this.age = player.getAge();
        this.experience = player.getExperience();
        this.teamDTO = new TeamDTO(player.getTeam());
        this.startCareer = player.getStartCareer();
    }


}
