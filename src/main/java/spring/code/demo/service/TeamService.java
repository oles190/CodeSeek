package spring.code.demo.service;

import spring.code.demo.dto.TeamDTO;
import spring.code.demo.model.Team;

import java.util.List;

public interface TeamService {


    TeamDTO create(TeamDTO teamDTO);

    TeamDTO update(TeamDTO teamDTO);

    TeamDTO findById(long id);

    List<TeamDTO> findAll();

    void delete(Long id);

    Team map(TeamDTO teamDTO);

    TeamDTO map(Team team);

}
