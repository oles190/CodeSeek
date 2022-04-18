package spring.code.demo.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.code.demo.CodeTestApplication;
import spring.code.demo.dto.TeamDTO;
import spring.code.demo.model.Team;
import spring.code.demo.repository.TeamRepository;
import spring.code.demo.service.TeamService;
import spring.code.demo.validator.team.create.TeamCreateValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootTest(classes = CodeTestApplication.class)
class TeamServiceImplTest {


    TeamService teamService;
    @Mock
    private TeamRepository teamRepository;
    @Autowired
    private List<TeamCreateValidator> teamCreateValidators;

    @BeforeEach
    void setUp() {
        teamService = new TeamServiceImpl(teamRepository, teamCreateValidators);
    }

    @Test
    void create() {
        TeamDTO teamDTO = listTeam().get(0);
        Team team = teamService.map(listTeam().get(0));
        teamService.create(teamDTO);
        Mockito.verify(teamRepository, Mockito.times(1)).save(team);
    }

    @Test
    void update() {
        TeamDTO teamDTO = listTeam().get(0);
        Team team = teamService.map(teamDTO);
        Mockito.when(teamRepository.findById(team.getId())).thenReturn(Optional.of(team));
        teamService.update(teamDTO);
        Mockito.verify(teamRepository, Mockito.times(1)).save(team);
    }

    @Test
    void findById() {
        TeamDTO teamDTO = listTeam().get(0);
        Team team = teamService.map(teamDTO);
        Mockito.when(teamRepository.findById(2L)).thenReturn(Optional.ofNullable(team));
        TeamDTO find = teamService.findById(2L);
        Assertions.assertEquals(teamDTO, find);
        Assertions.assertNotNull(find);
        Mockito.verify(teamRepository, Mockito.times(1)).findById(2L);
    }

    @Test
    void delete() {
        TeamDTO teamDTO = listTeam().get(0);
        Team team = teamService.map(teamDTO);
        Mockito.when(teamRepository.findById(team.getId())).thenReturn(Optional.of(team));
        teamService.delete(team.getId());
        Mockito.verify(teamRepository, Mockito.times(1)).deleteById(team.getId());
    }

    @Test
    void findAll() {
        List<TeamDTO> teamDTOS = listTeam();
        List<Team> listTeams = teamDTOS.stream().map(one -> teamService.map(one)).collect(Collectors.toList());
        Mockito.when(teamRepository.findAll()).thenReturn(listTeams);
        List<TeamDTO> findAll = teamService.findAll();
        Assertions.assertEquals(teamDTOS, findAll);
        Assertions.assertEquals(2, findAll.size());
    }

    public List<TeamDTO> listTeam() {
        List<TeamDTO> list = new ArrayList<>(Arrays.asList(
                new TeamDTO(1l, "Test1", 12L, "Lviv", "Ukraine", 1),
                new TeamDTO(2l, "Test2", 11L, "Odessa", "Ukraine", 3)
        ));
        return list;
    }
}



