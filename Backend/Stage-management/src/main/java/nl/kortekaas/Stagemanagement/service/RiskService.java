package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Item;
import nl.kortekaas.Stagemanagement.domain.Risk;
import nl.kortekaas.Stagemanagement.domain.Track;
import nl.kortekaas.Stagemanagement.domain.User;
import nl.kortekaas.Stagemanagement.persistence.ItemRepository;
import nl.kortekaas.Stagemanagement.persistence.RiskRepository;
import nl.kortekaas.Stagemanagement.persistence.TrackRepository;
import nl.kortekaas.Stagemanagement.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RiskService implements IRiskService {

    private static final String RISK_NOT_FOUND_ERROR = "Error: Risk is not found.";

    private RiskRepository riskRepository;
    private TrackRepository trackRepository;
    private ItemRepository itemRepository;

    @Autowired
    public void setTrackRepository(TrackRepository trackRepository) { this.trackRepository = trackRepository; }

    @Autowired
    public void setRiskRepository(RiskRepository riskRepository) { this.riskRepository = riskRepository; }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) { this.itemRepository = itemRepository; }

    @PreAuthorize("hasRole('STAGEMANAGER')")
    @Override
    public List<Risk> getRisks() {
        List<Risk> riskList = riskRepository.findAll();
        return riskList;
    }

    @Override
    public Risk getRiskById(Long id) {
        return riskRepository.findById(id).orElseThrow(
                () -> new RuntimeException(RISK_NOT_FOUND_ERROR));
    }

    @Override
    public Risk saveRisk(Risk newRisk) {
        return riskRepository.save(newRisk);
    }

    @Override
    public String deleteRisk(Long id) {
        Optional<Risk> risk = riskRepository.findById(id);
        if (risk.isPresent()) {
            riskRepository.deleteById(id);
            return "Risk with id " + risk.get().getId() + " is deleted.";
        }
        throw new RuntimeException(RISK_NOT_FOUND_ERROR);
    }

    @Override
    public Risk addRiskToTrack(Long id, Risk newRisk) {
        TrackRepository trackRepository = null;

        Optional<Track> track =
                trackRepository.findById(id);
        if(track.isPresent()) {
            newRisk.setTrack(track.get());
            return riskRepository.save(newRisk);
        }
        return null;
    }

    @Override
    public Risk addRiskToItem(Long id, Risk newRisk) {
        ItemRepository itemRepository = null;

        Optional<Item> item =
                itemRepository.findById(id);
        if(item.isPresent()) {
            newRisk.setItem(item.get());
            return riskRepository.save(newRisk);
        }
        return null;
    }
}
