package spring.code.demo.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

import java.util.Set;


@Entity
@Getter
@Setter
public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long balance;

    private String city;

    private  String country;

    private int commission;


    @OneToMany(mappedBy = "team", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Player> players ;


}

