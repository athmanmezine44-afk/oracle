package com.GestionNote.exam.Repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.GestionNote.exam.Entity.mongo.Note;
import java.util.List;

public interface Noterepo extends MongoRepository <Note, String> {

    List<Note> findByEtudiantId(Long etudiantId);

    List<Note> findByModuleId(Long moduleId);
}
