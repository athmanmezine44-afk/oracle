package com.GestionNote.exam.Repository.Oracle;

import com.GestionNote.exam.Entity.Oracle.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepository extends JpaRepository<Users,Long> {

    Optional<Users> findByUsername(String username);
}
