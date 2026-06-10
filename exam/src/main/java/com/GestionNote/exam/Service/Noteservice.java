package com.GestionNote.exam.Service;

import com.GestionNote.exam.Entity.mongo.Note;
import com.GestionNote.exam.Repository.mongo.Noterepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class Noteservice {
    final Noterepo noterepo;
    //ajouter une note
    public Note ajouterNote(Note note){
        return noterepo.save(note);
    }
    //modifier
    public Note modifierNote(String id, Note note){
        note.setId(id);
        return noterepo.save(note);
    }
    //supprimer
    public void supprimer(String id)
    {
        noterepo.deleteById(id);
    }
    public List<Note> getByEtudiant(Long etudiantId) {
        return noterepo.findByEtudiantId(etudiantId);
    }

}
