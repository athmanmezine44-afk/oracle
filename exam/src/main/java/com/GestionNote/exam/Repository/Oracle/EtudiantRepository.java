package com.GestionNote.exam.Repository.Oracle;

import com.GestionNote.exam.Entity.Oracle.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {
}
