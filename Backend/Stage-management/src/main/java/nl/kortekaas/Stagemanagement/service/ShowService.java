package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.model.Show;
import nl.kortekaas.Stagemanagement.persistence.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ShowService implements IShowService {

    private static final String SHOW_NOT_FOUND_ERROR = "Error: Show is not found.";

    private ShowRepository showRepository;

    @Autowired
    public void setShowRepository(ShowRepository showRepository) { this.showRepository = showRepository; }

    @Override
    public List<Show> getShows() {
        List<Show> showList = showRepository.findAll();
        return showList;
    }

    @Override
    public Show saveShow(Show newShow) { return showRepository.save(newShow); }

    @Override
    public String deleteShow(Long id) {
        Optional<Show> show = showRepository.findById(id);
        if (show.isPresent()) {
            showRepository.deleteById(id);
            return "Show " + show.get().getId() + " is deleted.";
        }
        throw new RuntimeException(SHOW_NOT_FOUND_ERROR);
    }
}
