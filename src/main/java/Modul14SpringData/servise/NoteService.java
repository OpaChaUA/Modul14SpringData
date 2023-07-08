package Modul14SpringData.servise;


import Modul14SpringData.entity.Note;
import Modul14SpringData.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
@RequiredArgsConstructor

@Service
public class NoteService {
    private final NoteRepository noteRepository;
    public List<Note> allNote() {
        return  (List<Note>) noteRepository.findAll();
    }

    public Note addNewNote(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
      noteRepository.delete(getById(id));
    }

    public void update(Note note) {
        long id = note.getId();
        Note existingNote = getById(id);
        if (existingNote != null) {
            existingNote.setTitle(note.getTitle());
            existingNote.setContent(note.getContent());
            noteRepository.save(existingNote);
        } else {
            throw new IllegalArgumentException("No note found for id: " + id); // Якщо нотатку не знайдено, кидаємо виняток
        }
    }


    public Note getById(long id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            return optionalNote.get();
        } else {
            throw new IllegalArgumentException("No note found for id: " + id);
        }
    }

}
