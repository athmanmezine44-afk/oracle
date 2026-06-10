package com.GestionNote.exam.Entity.Oracle;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="etudiant_id")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name="module_id")
    private Modulel module;
}