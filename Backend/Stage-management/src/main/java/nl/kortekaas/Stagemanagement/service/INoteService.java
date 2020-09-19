package nl.kortekaas.Stagemanagement.service;


import nl.kortekaas.Stagemanagement.model.Note;

import java.util.List;

public interface INoteService {

    List<Note> getNotes();
    Note getNoteById(Long id);
    Note saveNote(Note newNote);
    String deleteNote(Long id);
}
