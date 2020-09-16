package nl.kortekaas.Stagemanagement.persistence;

import nl.kortekaas.Stagemanagement.model.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {

//    Optional<Show> findByShowName(String name);
//    Optional<Show> findByPosterArt(String posterArt);
//    Optional<Show> findByStagemanager(String stagemanager);
}
