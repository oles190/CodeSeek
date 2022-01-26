package spring.code.demo.rest;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.code.demo.dto.PlayerDTO;
import spring.code.demo.dto.TeamDTO;
import spring.code.demo.model.Player;
import spring.code.demo.model.Team;
import spring.code.demo.service.PlayerService;
import spring.code.demo.service.TeamService;
import java.util.List;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/player")
@Log4j
public class PlayerRestController {

    private final PlayerService playerService;
    private final TeamService teamService;

    @Autowired
    public PlayerRestController(PlayerService playerService, TeamService teamService) {
        this.playerService = playerService;
        this.teamService = teamService;
    }


    @GetMapping("/all")
    public List<PlayerDTO> getAll() {

        List<Player> players = playerService.getAll();
        return  players.stream().map(playerService::map).collect( Collectors.toList() );

    }

    @Tag(name = "All Team", description = "All players in this team")
    @GetMapping("/all/byTeam")
    public List<PlayerDTO> getByTeam(@RequestBody TeamDTO teamDTO){

        Team team =  teamService.map(teamDTO);
        return playerService.getByTeam(team);
    }

//    @Hidden  приховати в swagger
    @PostMapping("/create")
    public PlayerDTO addPlayer(@RequestBody() PlayerDTO playerDTO) {

        return playerService.map(playerService.create(playerDTO));

    }

    @Tag(name = "Transfer", description = "Transfer players")
    @PostMapping("/transfer")
    public void transfer(@RequestParam()  Long teamId, @RequestParam() Long playerId) {
        Team team = teamService.findById(teamId);
        playerService.transfer(playerId, team);
        log.info("Success!");

    }


    @PostMapping("/update")
    public PlayerDTO update(@RequestBody PlayerDTO playerDTO){
      return playerService.map(playerService.update(playerDTO));
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable() Long id)   {
        playerService.delete(id);
    }

}
