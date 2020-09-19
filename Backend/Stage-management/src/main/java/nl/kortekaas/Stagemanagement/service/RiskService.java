package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.model.Risk;
import nl.kortekaas.Stagemanagement.persistence.RiskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RiskService implements IRiskService {

    private static final String RISK_NOT_FOUND_ERROR = "Error: Risk is not found.";

    private RiskRepository riskRepository;

    @Autowired
    public void setRiskRepository(RiskRepository riskRepository) { this.riskRepository = riskRepository; }


    @PreAuthorize("hasRole('STAGEMANAGER')")
    @Override
    public List<Risk> getRisks() {
        return riskRepository.findAll();
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

}
