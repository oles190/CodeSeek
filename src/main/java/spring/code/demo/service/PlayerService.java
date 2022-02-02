package spring.code.demo.service;

import spring.code.demo.dto.PlayerDTO;
import spring.code.demo.dto.TeamDTO;
import spring.code.demo.model.Player;

import java.util.List;

public interface PlayerService {


    PlayerDTO create(PlayerDTO playerDTO);

    PlayerDTO update(PlayerDTO playerDTO);

    PlayerDTO findById(long id);

    List<PlayerDTO> findAll();

    void delete(long id);

    void transfer(Long id, Long teamId);

    Player map(PlayerDTO playerDTO);

    PlayerDTO map(Player player);

    List<PlayerDTO> findByTeam(TeamDTO teamDTO);


}
