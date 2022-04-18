package spring.code.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.code.demo.dto.TeamDTO;
import spring.code.demo.exception.team.TeamNotFoundException;
import spring.code.demo.model.Team;
import spring.code.demo.repository.TeamRepository;
import spring.code.demo.service.TeamService;
import spring.code.demo.validator.team.create.TeamCreateValidator;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
    public TeamDTO create(TeamDTO teamDTO) {
        Team team = map(teamDTO);
        for (TeamCreateValidator createValidator : teamCreateValidators) {
            createValidator.validate(team);
        }
        teamRepository.save(team);
        return map(team);
    }

    @Override
    public TeamDTO update(TeamDTO teamDTO) {
        findById(teamDTO.getId());
        return create(teamDTO);
    }


    @Override
    public TeamDTO findById(long id) {
        Optional<Team> team = teamRepository.findById(id);
        if (team.isPresent()) {
            return map(team.get());
        }
        throw new TeamNotFoundException("Team with id " + id + " not found!");
    }

    @Override
    @Transactional(rollbackFor = TeamNotFoundException.class)
    public void delete(Long id) {
        TeamDTO teamDTO = findById(id);
        if (teamDTO == null) {
            throw new TeamNotFoundException("Team not found");
        }
           teamRepository.deleteById(id);
    }

    @Override
    public List<TeamDTO> findAll() {
        List<Team> lists = teamRepository.findAll();
        return lists.stream().map(this::map).collect(Collectors.toList());
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
        return new TeamDTO(team);
    }

}
