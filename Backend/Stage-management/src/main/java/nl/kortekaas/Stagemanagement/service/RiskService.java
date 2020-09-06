package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Risk;
import nl.kortekaas.Stagemanagement.domain.Track;
import nl.kortekaas.Stagemanagement.persistence.ItemRepository;
import nl.kortekaas.Stagemanagement.persistence.RiskRepository;
import nl.kortekaas.Stagemanagement.persistence.TrackRepository;
import nl.kortekaas.Stagemanagement.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RiskService implements IRiskService {

    private TrackRepository trackRepository;
    private RiskRepository riskRepository;
    private ItemRepository itemRepository;

    @Autowired
    public void setTrackRepository(TrackRepository trackRepository) { this.trackRepository = trackRepository; }

    @Autowired
    public void setRiskRepository(RiskRepository riskRepository) { this.riskRepository = riskRepository; }

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) { this.itemRepository = itemRepository; }

    @PreAuthorize("hasRole('STAGEMANAGER')")
    public List<Risk> getRisks() {
        List<Risk> riskList = riskRepository.findAll();
        return riskList;
    }
}
