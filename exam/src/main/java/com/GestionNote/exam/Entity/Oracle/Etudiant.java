package com.GestionNote.exam.Entity.Oracle;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_etudiant;

    private String nom;
    private String prenom;
    private String email;
    private String filiere;
    private int annee;

}
