package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Track;
import nl.kortekaas.Stagemanagement.persistence.RiskRepository;
import nl.kortekaas.Stagemanagement.persistence.TrackRepository;
import nl.kortekaas.Stagemanagement.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackService implements ITrackService {

    private TrackRepository trackRepository;
    private RiskRepository riskRepository;
    private UserRepository userRepository;

    @Autowired
    public void setTrackRepository(TrackRepository trackRepository) { this.trackRepository = trackRepository; }

    @Autowired
    public void setRiskRepository(RiskRepository riskRepository) { this.riskRepository = riskRepository; }

    @Autowired
    public void setUserRepository(UserRepository userRepository) { this.userRepository = userRepository; }

    @Override
    public List<Track> getTracks() {
        List<Track> trackList = trackRepository.findAll();
        return trackList;
    }

}
