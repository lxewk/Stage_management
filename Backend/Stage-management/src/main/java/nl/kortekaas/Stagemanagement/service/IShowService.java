package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.model.Show;

import java.util.List;

public interface IShowService {
    List<Show> getShows();
    Show saveShow(Show newShow);
    String deleteShow(Long id);


//    String findByShowName();
//    String findByPosterArt();
//    String findByStagemanager();

}
