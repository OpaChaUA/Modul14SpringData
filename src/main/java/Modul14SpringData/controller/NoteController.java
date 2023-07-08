package Modul14SpringData.controller;

import Modul14SpringData.entity.Note;
import Modul14SpringData.servise.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/note")

public class NoteController {
    private final NoteService noteService;
    @GetMapping("/add")
    public ModelAndView addNote(@RequestParam("note") Note addNote){
        noteService.addNewNote(addNote);
        ModelAndView result = new ModelAndView("redirect:/note/list");
        result.addObject("notes", noteService.allNote());
        return result;
    }

    @GetMapping("/list")
    public ModelAndView allNote() {
        ModelAndView result = new ModelAndView("list");
        result.addObject("notes", noteService.allNote());
        return result;
    }
    @PostMapping("/delet")
    public ModelAndView deleteNote(@RequestParam("id") long id){
        noteService.deleteById(id);
        ModelAndView result = new ModelAndView("redirect:/note/list");
        result.addObject("notes",noteService.allNote());

        return result;

    }
    @GetMapping("/edit")
    public ModelAndView editPage (@RequestParam("id") long id){

        ModelAndView result = new ModelAndView("edit");
        result.addObject("notes", noteService.getById(id));
        return result;
    }

    @PostMapping("/edit")
    public ModelAndView editNote(@RequestParam("note") Note updateNote) {
        noteService.update(updateNote);
        ModelAndView result = new ModelAndView("redirect:/note/list");
        result.addObject("notes", noteService.allNote());
        return result;
    }
}
