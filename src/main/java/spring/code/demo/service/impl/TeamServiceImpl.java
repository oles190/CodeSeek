package spring.code.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.code.demo.dto.TeamDTO;
import spring.code.demo.exception.team.TeamNotFoundException;
import spring.code.demo.model.Team;
import spring.code.demo.repository.TeamRepository;
import spring.code.demo.service.TeamService;
import spring.code.demo.validator.team.create.TeamCreateValidator;
import java.util.List;
import java.util.Optional;


@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final List<TeamCreateValidator> teamCreateValidators;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, List<TeamCreateValidator> teamCreateValidators) {
        this.teamRepository = teamRepository;
        this.teamCreateValidators = teamCreateValidators;
    }

    @Override
    public Team create(TeamDTO teamDTO) {
      Team team =map(teamDTO);
      for(TeamCreateValidator createValidator: teamCreateValidators){
          createValidator.validate(team);
      }
     return teamRepository.save(team);

    }

        @Override
        public Team update(TeamDTO teamDTO) {

        if (teamDTO.getId() == null) {
            throw new IllegalArgumentException("Id can't be null!");
        }
            for(TeamCreateValidator createValidator: teamCreateValidators){
                createValidator.validate(map(teamDTO));
            }
        Team team = map(teamDTO);
        return  teamRepository.save(team);
    }


    @Override
    public Team findById(long id) {
        Optional<Team> team = teamRepository.findById(id);
        if(team.isPresent()){
            return  team.get();
        }
        throw  new TeamNotFoundException("Team with id "+id +" not found!");

    }

    @Override
    public void delete(Long id) {
        Team team = findById(id);
        if(team == null){
            throw new TeamNotFoundException("Team not found");

        }
        teamRepository.delete(team);


    }

    @Override
    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team map(TeamDTO teamDTO) {
    Team team = new Team();
    team.setBalance(teamDTO.getBalance());
    team.setCity(teamDTO.getCity());
    team.setCommission(teamDTO.getCommission());
    team.setCountry(teamDTO.getCountry());
    team.setId(teamDTO.getId());
    team.setName(teamDTO.getName());

       return team;
    }

    @Override
    public TeamDTO map(Team team) {
        return  new TeamDTO(team);
    }

}
