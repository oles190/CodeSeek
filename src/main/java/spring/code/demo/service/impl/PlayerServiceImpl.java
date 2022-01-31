package spring.code.demo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.code.demo.dto.PlayerDTO;
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
    private  final List<PlayerCreateValidator> playerCreateValidators;

    @Autowired
    public PlayerServiceImpl(TeamService teamService, PlayerRepository playerRepository,
                             List<PlayerCreateValidator> playerCreateValidators) {
        this.teamService = teamService;
        this.playerRepository = playerRepository;
        this.playerCreateValidators = playerCreateValidators;
    }



    @Override
    public Player create (PlayerDTO playerDTO) {
        Player player = map(playerDTO);
        for(PlayerCreateValidator validator:playerCreateValidators){
            validator.validate(player);
        }

        return  playerRepository.save(player);

    }

    @Override
    public Player update(PlayerDTO playerDTO) {

        if (playerDTO.getId() == null) {
            throw new IllegalArgumentException("Id cant be null");
        }

        for(PlayerCreateValidator validator:playerCreateValidators){
            validator.validate( map(playerDTO) );
        }
        Player player = map(playerDTO);
      return  playerRepository.save(player);

    }

    @Override
    public Player findById(long id) {

        Optional<Player> player = playerRepository.findById(id);
        if(player.isPresent()){
            return player.get();
        }else {

         throw  new PlayerNotFoundException("Player with id " + id + " not found!");
        }

    }

    @Override
    public void delete(long id) {
    Player player = findById(id);

    if(player == null){
    throw  new PlayerNotFoundException("Player with id "+ id+ " not found!");
    }
        playerRepository.delete(player);


    }

    @Override
    public List<Player> getAll() {
        return playerRepository.findAll();
    }


    public void transfer(Long id, Team newTeam){
    Player player = findById(id);

    if( player.getTeam().equals(newTeam) ){
            throw new IllegalArgumentException("This player has already played in this team!");
    }
     int allPrice = calcSumTransfer(map(player));

    if(newTeam.getBalance() < allPrice){
            throw  new IllegalArgumentException("Balance not enough");
        }

    player.getTeam().setBalance(player.getTeam().getBalance() + allPrice);
    newTeam.setBalance(newTeam.getBalance() - allPrice);
    player.setTeam(newTeam);
    teamService.create( teamService.map(newTeam) );

    create( map(player) );
        log.info("Success!");


    }


    public int calcSumTransfer(PlayerDTO playerDTO){
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
        return  player;
    }

    @Override
    public PlayerDTO map(Player player) {
       return new PlayerDTO(player);


    }
    public List<PlayerDTO> getByTeam(Team team){
     List<Player> lists = playerRepository.getByTeam(team);

     return  lists.stream().map(this::map).collect( Collectors.toList() );
    }
}




