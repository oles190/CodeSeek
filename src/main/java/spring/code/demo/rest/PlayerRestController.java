package spring.code.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.code.demo.dto.PlayerDTO;
import spring.code.demo.dto.TeamDTO;
import spring.code.demo.service.PlayerService;

import java.util.List;


@RestController
@RequestMapping("/player")
public class PlayerRestController {

    private final PlayerService playerService;

    @Autowired
    public PlayerRestController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping("/all")
    public List<PlayerDTO> findAll() {
        return playerService.findAll();
    }

    @GetMapping("/all/byTeam")
    public List<PlayerDTO> findByTeam(@RequestBody TeamDTO teamDTO) {
        return playerService.findByTeam(teamDTO);
    }

    @GetMapping("/{id}")
    public PlayerDTO findById(@PathVariable long id) {
        return playerService.findById(id);
    }


    @PostMapping()
    public PlayerDTO addPlayer(@RequestBody() PlayerDTO playerDTO) {
        return playerService.create(playerDTO);
    }

    @PostMapping("/transfer")
    public void transfer(@RequestParam() Long teamId, @RequestParam() Long playerId) {
        playerService.transfer(playerId, teamId);
    }


    @PutMapping()
    public PlayerDTO update(@RequestBody PlayerDTO playerDTO) {
        return playerService.update(playerDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable() Long id) {
        playerService.delete(id);
    }

}
