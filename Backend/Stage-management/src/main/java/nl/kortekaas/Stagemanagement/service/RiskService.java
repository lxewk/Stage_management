package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Risk;
import nl.kortekaas.Stagemanagement.domain.Track;
import nl.kortekaas.Stagemanagement.persistence.ItemRepository;
import nl.kortekaas.Stagemanagement.persistence.RiskRepository;
import nl.kortekaas.Stagemanagement.persistence.TrackRepository;
import nl.kortekaas.Stagemanagement.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Risk> getRisk() {
        List<Risk> riskList = riskRepository.findAll();
        return riskList;
    }
}
