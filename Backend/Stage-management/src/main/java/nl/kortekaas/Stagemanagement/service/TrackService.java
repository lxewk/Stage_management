package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.model.Track;
import nl.kortekaas.Stagemanagement.persistence.RiskRepository;
import nl.kortekaas.Stagemanagement.persistence.TrackRepository;
import nl.kortekaas.Stagemanagement.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService implements ITrackService {

    private static final String TRACK_NOT_FOUND_ERROR = "Error: Track is not found.";

    private TrackRepository trackRepository;
    private RiskRepository riskRepository;
    private UserRepository userRepository;

    @Autowired
    public void setTrackRepository(TrackRepository trackRepository) { this.trackRepository = trackRepository; }

    @Autowired
    public void setRiskRepository(RiskRepository riskRepository) { this.riskRepository = riskRepository; }

    @Autowired
    public void setUserRepository(UserRepository userRepository) { this.userRepository = userRepository; }

    @PreAuthorize("hasRole('STAGEMANAGER') or hasRole('ASSISTANT') or hasRole('CREW')")
    @Override
    public List<Track> getTracks() {
        List<Track> trackList = trackRepository.findAll();
        return trackList;
    }

    @Override
    public Track getTrackById(Long id) {
        return trackRepository.findById(id).orElseThrow(
                () -> new RuntimeException(TRACK_NOT_FOUND_ERROR));
    }

    @Override
    public Track saveTrack(Track newTrack) {
        return trackRepository.save(newTrack);
    }

    @Override
    public String deleteTrack(Long id) {
        Optional<Track> track = trackRepository.findById(id);
        if (track.isPresent()) {
            trackRepository.deleteById(id);
            return "Track with id " + track.get().getTrackId() + " is deleted.";
        }
        throw new RuntimeException(TRACK_NOT_FOUND_ERROR);
    }

}
