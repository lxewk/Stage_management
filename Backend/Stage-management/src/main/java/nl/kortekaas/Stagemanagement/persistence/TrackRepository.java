package nl.kortekaas.Stagemanagement.persistence;

import nl.kortekaas.Stagemanagement.model.Role;
import nl.kortekaas.Stagemanagement.model.Track;
import nl.kortekaas.Stagemanagement.model.enums.ERole;
import nl.kortekaas.Stagemanagement.model.enums.ETrack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TrackRepository extends JpaRepository<Track, Long> {

    Optional<Track> findByPosition(ETrack position);

}
