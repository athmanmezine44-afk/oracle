package com.GestionNote.exam.Controller;

import com.GestionNote.exam.Entity.mongo.Note;
import com.GestionNote.exam.Service.Noteservice;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@AllArgsConstructor
public class NoteController {
    private final Noteservice noteservice;

    @PostMapping
    public Note add(@RequestBody Note note){
        return noteservice.ajouterNote(note);
    }
    @PutMapping("/{id}")
    public Note update(@PathVariable String id,@RequestBody Note note){
        return noteservice.modifierNote(id,note);
    }
    @DeleteMapping("/{id}")
    public void delet(@PathVariable String id){
        noteservice.supprimer(id);
    }
    @GetMapping("/etudiant/{id}")
    public List<Note> getByEtudinat(@PathVariable Long id){
        return noteservice.getByEtudiant(id);
    }
}
