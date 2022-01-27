package spring.code.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.code.demo.model.Player;
import spring.code.demo.model.Team;
import java.util.List;


public interface PlayerRepository extends JpaRepository<Player,Long> {

List<Player> getByTeam(Team team);

}
