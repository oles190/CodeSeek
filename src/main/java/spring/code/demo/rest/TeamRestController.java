package spring.code.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.code.demo.dto.TeamDTO;
import spring.code.demo.exception.team.TeamNotFoundException;
import spring.code.demo.service.TeamService;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamRestController {

    private final TeamService teamService;

    @Autowired
    public TeamRestController(TeamService teamService) {
        this.teamService = teamService;

    }

    @GetMapping("/all")
    public List<TeamDTO> findAll() {
        return teamService.findAll();
    }

    @GetMapping("/{id}")
    public TeamDTO findById(@PathVariable() Long id) {
        return teamService.findById(id);
    }


    @PostMapping()
    public TeamDTO create(@RequestBody() TeamDTO teamDTO) {

        return teamService.create(teamDTO);
    }


    @PutMapping()
    public TeamDTO update(@RequestBody() TeamDTO teamDTO) {
        return teamService.update(teamDTO);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable() Long id) throws TeamNotFoundException {

        teamService.delete(id);


    }


}





