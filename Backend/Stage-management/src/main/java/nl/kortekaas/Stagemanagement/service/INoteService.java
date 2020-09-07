package nl.kortekaas.Stagemanagement.service;

import nl.kortekaas.Stagemanagement.domain.Item;
import nl.kortekaas.Stagemanagement.domain.Note;

import java.util.List;

public interface INoteService {

    List<Note> getNotes();
    Note getNoteById(Long id);
    Note saveNote(Note newNote);
    String deleteNote(Long id);
    Note addNoteToUser(Long id, Note newNote);
}
