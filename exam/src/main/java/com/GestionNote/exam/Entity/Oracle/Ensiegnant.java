package com.GestionNote.exam.Entity.Oracle;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ensiegnant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private String specialite;

    @OneToMany(mappedBy = "enseignant")
    private List<Modulel> modules;
}