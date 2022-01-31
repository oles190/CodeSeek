package spring.code.demo.service;

import spring.code.demo.dto.PlayerDTO;
import spring.code.demo.model.Player;
import spring.code.demo.model.Team;

import java.util.List;

public interface PlayerService {


    Player create(PlayerDTO playerDTO);

    Player update(PlayerDTO playerDTO);

    Player findById(long id);

    void delete(long id);

    List<PlayerDTO> getAll();

    void transfer(Long id, Long teamId);

    Player map(PlayerDTO playerDTO);

    PlayerDTO map(Player player);

    List<PlayerDTO> getByTeam(Team team);


}

