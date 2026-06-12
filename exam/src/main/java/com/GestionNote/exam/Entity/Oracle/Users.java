package com.GestionNote.exam.Entity.Oracle;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.GestionNote.exam.Entity.Oracle.*;
import lombok.NoArgsConstructor;

@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private User_Role role;
    @OneToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;
    @OneToOne
    @JoinColumn(name = "ensiegnant_id")
    private Ensiegnant ensiegnant;
}
