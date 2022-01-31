package spring.code.demo.service;

import spring.code.demo.dto.TeamDTO;
import spring.code.demo.model.Team;

import java.util.List;

public interface TeamService {


    Team create(TeamDTO teamDTO);

    Team update(TeamDTO teamDTO);

    Team findById(long id);

    void delete(Long id);

    List<TeamDTO> getAll();

    Team map(TeamDTO teamDTO);

    TeamDTO map(Team team);

}
