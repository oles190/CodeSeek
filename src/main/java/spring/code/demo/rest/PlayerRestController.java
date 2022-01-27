package spring.code.demo.rest;

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
        return players
                .stream()
                .map(playerService::map)
                .collect( Collectors.toList() );

    }

    @GetMapping("/all/byTeam")
    public List<PlayerDTO> getByTeam(@RequestBody TeamDTO teamDTO){

        Team team = teamService.map(teamDTO);

        return playerService.getByTeam(team);
    }

    @GetMapping("/{id}")
    public PlayerDTO findById (@PathVariable  long id){

        return playerService.map( playerService.findById(id) );
    }


    @PostMapping()
    public PlayerDTO addPlayer(@RequestBody() PlayerDTO playerDTO) {

        return playerService.map( playerService.create(playerDTO) );

    }

    @PostMapping("/transfer")
    public void transfer(@RequestParam()  Long teamId, @RequestParam() Long playerId) {
        Team team = teamService.findById(teamId);
        playerService.transfer(playerId, team);

    }



    @PutMapping()
    public PlayerDTO update(@RequestBody PlayerDTO playerDTO){
      return playerService.map(playerService.update(playerDTO));
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable() Long id)   {
        playerService.delete(id);
    }

}
