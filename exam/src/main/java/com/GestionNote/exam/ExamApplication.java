package com.GestionNote.exam;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.GestionNote.exam.Entity.Oracle.*;
import com.GestionNote.exam.Repository.Oracle.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.Serializable;
import java.util.List;

@SpringBootApplication
public class ExamApplication implements Serializable {

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			EnsiegnantRepository ensiegnantRepository,
			EtudiantRepository etudiantRepository,
			ModuleRepository moduleRepository,
			userRepository userRepository,
			InscreptionRepository inscriptionRepository,PasswordEncoder passwordEncoder) {

		return args -> {

			// ================= ETUDIANT =================

			Etudiant etudiant = new Etudiant();
			etudiant.setNom("Mansouri");
			etudiant.setPrenom("Taoufik");
			etudiant.setAnnee(2025);
			etudiant.setFiliere("SMI");

			etudiantRepository.save(etudiant);

			// ================= ENSEIGNANT =================

			Ensiegnant ensiegnant = new Ensiegnant();
			ensiegnant.setNom("Mamoni");
			ensiegnant.setPrenom("Mohamed");
			ensiegnant.setSpecialite("Math");

			ensiegnantRepository.save(ensiegnant);

			// ================= MODULE =================

			Modulel module = new Modulel();
			module.setIntitule("Boite à merveille");
			module.setCoefficient(1);
			module.setSemestre(2);
			module.setSessionClose(false);
			module.setEnseignant(ensiegnant);

			moduleRepository.save(module);

			ensiegnant.setModules(List.of(module));
			ensiegnantRepository.save(ensiegnant);

			// ================= ADMIN =================


			// ================= USER ENSEIGNANT =================

			Users userProf = new Users();
			userProf.setUsername("mohamed");
			userProf.setPassword(passwordEncoder.encode("mohamed123"));
			userProf.setRole(User_Role.ENSIEGNANT);
			userProf.setEnsiegnant(ensiegnant);

			userRepository.save(userProf);

			// ================= USER ETUDIANT =================

			Users userEtudiant = new Users();
			userEtudiant.setUsername("taoufik");
			userEtudiant.setPassword(passwordEncoder.encode("taoufik123"));
			userEtudiant.setRole(User_Role.ETUDIANT);
			userEtudiant.setEtudiant(etudiant);

			userRepository.save(userEtudiant);

			// ================= INSCRIPTION =================

			Inscription inscription = new Inscription();
			inscription.setEtudiant(etudiant);
			inscription.setModule(module);

			inscriptionRepository.save(inscription);

			System.out.println("====================================");
			System.out.println("DONNEES INSEREES AVEC SUCCES");
			System.out.println("admin / admin123");
			System.out.println("mohamed / mohamed123");
			System.out.println("taoufik / taoufik123");
			System.out.println("====================================");
		};
	}
}