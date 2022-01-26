package spring.code.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.code.demo.dto.TeamDTO;
import spring.code.demo.exception.team.TeamNotFoundException;
import spring.code.demo.model.Team;
import spring.code.demo.service.TeamService;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/team")
public class TeamRestController {

    private final TeamService teamService;

    @Autowired
    public TeamRestController(TeamService teamService) {
        this.teamService = teamService;

    }
    @GetMapping("/all")
    public List<TeamDTO> findAll(){
        List<Team>  lists = teamService.getAll();
        return lists.stream().map(teamService::map).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public TeamDTO findById(@PathVariable() Long id){
        return teamService.map(teamService.findById(id));
    }


    @PostMapping("/create")
    public TeamDTO create(@RequestBody() TeamDTO teamDTO){

        return teamService.map(teamService.create(teamDTO));
    }


    @PostMapping("/update")
    public TeamDTO update(@RequestBody() TeamDTO teamDTO){
    return  teamService.map(teamService.update(teamDTO));
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable() Long id) throws TeamNotFoundException {

       teamService.delete(id);



     }


    }






