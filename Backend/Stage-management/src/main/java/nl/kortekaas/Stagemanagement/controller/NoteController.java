package nl.kortekaas.Stagemanagement.controller;

import nl.kortekaas.Stagemanagement.domain.Item;
import nl.kortekaas.Stagemanagement.domain.Note;
import nl.kortekaas.Stagemanagement.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/note")
public class NoteController {

    @Autowired
    private INoteService noteService;

    @GetMapping(value = "/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id);
    }

    @DeleteMapping(value = "/{id}")
    public String deleteNote(@PathVariable Long id) {
        return noteService.deleteNote(id);
    }

    @PostMapping(value = "/{userid}")
    public Note addNoteToUserById(@PathVariable long userid,
                                  @RequestBody Note newNote) {
        return noteService.saveNote(newNote);
    }


//    public void sendNote(User receiverUser, User activeUser) {
//        System.out.println(receiverUser + " You've got a note");
//        int toSend = receiverUser.getReceivedNote();
//        receiverUser.setReceivedNote(toSend);
//    }
}
