package nl.kortekaas.Stagemanagement.persistence;

import nl.kortekaas.Stagemanagement.domain.ETask;
import nl.kortekaas.Stagemanagement.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrackRepository extends JpaRepository<TrackRepository, Long> {

    Optional<Track> findByTask(ETask task);
}
