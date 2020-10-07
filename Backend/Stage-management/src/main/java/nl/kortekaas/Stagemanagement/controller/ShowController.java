package nl.kortekaas.Stagemanagement.controller;

import nl.kortekaas.Stagemanagement.model.Show;
import nl.kortekaas.Stagemanagement.service.IShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/show")
public class ShowController {

    @Autowired
    private IShowService showService;

    @GetMapping(value = "/all")
    public List<Show> getShows() { return showService.getShows(); }

    @PostMapping(value = "/save")
    public Show saveShow(@RequestBody Show newShow) { return showService.saveShow(newShow); }

    @DeleteMapping(value = "/{id}")
    public String deleteShow(@PathVariable Long id) { return showService.deleteShow(id); }

}
