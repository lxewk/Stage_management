package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Track;

import java.util.List;

public interface ITrackService {

    List<Track> getTracks();
    Track getTrackById(Long id);
    Track saveTrack(Track newTrack);
    String deleteTrack(Long id);

}
