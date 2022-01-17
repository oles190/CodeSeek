package spring.code.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.code.demo.model.Team;

public interface TeamRepository extends JpaRepository<Team,Long> {

}

