package nl.kortekaas.Stagemanagement.controller;

import nl.kortekaas.Stagemanagement.domain.Item;
import nl.kortekaas.Stagemanagement.domain.Risk;
import nl.kortekaas.Stagemanagement.service.IItemService;
import nl.kortekaas.Stagemanagement.service.RiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/risk")
public class RiskController {

    @Autowired
    private RiskService riskService;

    @GetMapping(value = "/{id}")
    public Risk getRiskById(@PathVariable Long id) {
        return riskService.getRiskById(id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteRisk(@PathVariable Long id) {
        return riskService.deleteRisk(id);
    }

    @PostMapping(value = "/{trackid}")
    public Risk addRiskToTrackById(@PathVariable long trackid,
                                  @RequestBody Risk newRisk) {
        return riskService.saveRisk(newRisk);
    }

    @PostMapping(value = "/{itemid}")
    public Risk addRiskToItemById(@PathVariable long itemid,
                                   @RequestBody Risk newRisk) {
        return riskService.saveRisk(newRisk);
    }
}
