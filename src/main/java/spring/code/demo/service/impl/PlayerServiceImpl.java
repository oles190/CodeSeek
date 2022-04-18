package spring.code.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.code.demo.dto.PlayerDTO;
import spring.code.demo.dto.TeamDTO;
import spring.code.demo.exception.player.PlayerNotFoundException;
import spring.code.demo.model.Player;
import spring.code.demo.model.Team;
import spring.code.demo.repository.PlayerRepository;
import spring.code.demo.service.PlayerService;
import spring.code.demo.service.TeamService;
import spring.code.demo.validator.player.create.PlayerCreateValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Slf4j
public class PlayerServiceImpl implements PlayerService {

    private final TeamService teamService;
    private final PlayerRepository playerRepository;
    private final List<PlayerCreateValidator> playerCreateValidators;

    @Autowired
    public PlayerServiceImpl(TeamService teamService, PlayerRepository playerRepository,
                             List<PlayerCreateValidator> playerCreateValidators) {
        this.teamService = teamService;
        this.playerRepository = playerRepository;
        this.playerCreateValidators = playerCreateValidators;
    }


    @Override
    public PlayerDTO create(PlayerDTO playerDTO) {
        Player player = map(playerDTO);
        for (PlayerCreateValidator validator : playerCreateValidators) {
            validator.validate(player);
        }
        playerRepository.save(player);
        return map(player);
    }

    @Override
    public PlayerDTO update(PlayerDTO playerDTO) {
        findById(playerDTO.getId());
        return create(playerDTO);
    }

    @Override
    public PlayerDTO findById(long id) {
        Optional<Player> player = playerRepository.findById(id);
        if (player.isPresent()) {
            return map(player.get());
        }
        throw new PlayerNotFoundException(String.format("Player with id %d not found",id));

    }

    @Override
    public void delete(long id) {
        PlayerDTO player = findById(id);
        if (player == null) {
            throw new PlayerNotFoundException("Player with id " + id + " not found!");
        }
        playerRepository.deleteById(id);
    }

    @Override
    public List<PlayerDTO> findAll() {
        List<Player> players = playerRepository.findAll();
        return players.stream().map(this::map).collect(Collectors.toList());
    }

    public void transfer(Long playerId, Long teamId) {
        Player player = map(findById(playerId));
        Team newTeam = teamService.map(teamService.findById(teamId));
        if (player.getTeam().equals(newTeam)) {
            throw new IllegalArgumentException("This player has already played in this team!");
        }
        int allPrice = calcSumTransfer(map(player));
        if (newTeam.getBalance() < allPrice) {
            throw new IllegalArgumentException("Balance not enough");
        }
        Team previousTeam = player.getTeam();
        previousTeam.setBalance(player.getTeam().getBalance() + allPrice);
        newTeam.setBalance(newTeam.getBalance() - allPrice);
        player.setTeam(newTeam);
        teamService.update(teamService.map(newTeam));
        teamService.update(teamService.map(previousTeam));
        update(map(player));
        log.info("Success!");
    }


    public int calcSumTransfer(PlayerDTO playerDTO) {
        int priceTransfer = playerDTO.getExperience() * 100000 / playerDTO.getAge();
        int commission = priceTransfer / 100 * playerDTO.getTeamDTO().getCommission();
        return priceTransfer + commission;
    }

    @Override
    public Player map(PlayerDTO playerDTO) {
        Player player = new Player();
        player.setName(playerDTO.getName());
        player.setExperience(playerDTO.getExperience());
        player.setId(playerDTO.getId());
        player.setAge(playerDTO.getAge());
        player.setLastName(playerDTO.getLastName());
        player.setStartCareer(playerDTO.getStartCareer());
        player.setTeam((teamService.map(playerDTO.getTeamDTO())));
        return player;
    }

    @Override
    public PlayerDTO map(Player player) {
        return new PlayerDTO(player);
    }

    public List<PlayerDTO> findByTeam(TeamDTO teamDTO) {
        List<Player> lists = playerRepository.findByTeam(teamService.map(teamDTO));
        return lists.stream().map(this::map).collect(Collectors.toList());
    }
}



