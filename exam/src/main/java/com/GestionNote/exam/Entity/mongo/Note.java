package com.GestionNote.exam.Entity.mongo;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@AllArgsConstructor
@Document(collection = "notes")
public class Note{

    @Id
    private String id;

    private Long etudiantId;
    private Long moduleId;

    private Double note;
    private String appreciation;

    private String session; // normale / rattrapage

    private Date dateSaisie;

    // sous-notes
    private Double tp;
    private Double controleContinu;
    private Double examen;
}