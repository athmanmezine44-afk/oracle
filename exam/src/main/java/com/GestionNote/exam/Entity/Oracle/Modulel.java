package com.GestionNote.exam.Entity.Oracle;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Modulel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String intitule;
    private double coefficient;
    private int semestre;

    private boolean sessionClose;

    @ManyToOne
    @JoinColumn(name = "enseignant_id")
    private Ensiegnant enseignant;
}