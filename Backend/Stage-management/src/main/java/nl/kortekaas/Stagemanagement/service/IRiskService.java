package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Risk;

import java.util.List;

public interface IRiskService {

    List<Risk> getRisks();
    Risk getRiskById(Long id);
    Risk saveRisk(Risk newRisk);
    String deleteRisk(Long id);
    Risk addRiskToTrack(Long id, Risk newRisk);
    Risk addRiskToItem(Long id, Risk newRisk);
}
