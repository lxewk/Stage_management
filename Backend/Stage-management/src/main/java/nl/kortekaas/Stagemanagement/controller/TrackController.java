package nl.kortekaas.Stagemanagement.controller;

import nl.kortekaas.Stagemanagement.domain.Track;
import nl.kortekaas.Stagemanagement.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/track")
public class TrackController {

    @Autowired
    private TrackService trackService;

    @GetMapping(value = "/{id}")
    public Track getTrackById(@PathVariable Long id) {
        return trackService.getTrackById(id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteTrack(@PathVariable Long id) {
        return trackService.deleteTrack(id);
    }
}
