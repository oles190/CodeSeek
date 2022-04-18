package spring.code.demo.model;

import lombok.Data;


import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Player {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private int age;

    private int experience;

    private LocalDate startCareer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;


}