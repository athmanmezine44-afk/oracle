package com.GestionNote.exam.Controller;

import com.GestionNote.exam.Entity.Oracle.Users;
import com.GestionNote.exam.Repository.Oracle.userRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class LoginController {

    private userRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @PostMapping("/login")
    public String handlLogin(
            @RequestParam String username,
            @RequestParam String password,
            Model model) {

        Optional<Users> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect.");
            return "login";
        }

        Users user = optionalUser.get();

        if (!passwordEncoder.matches(password, user.getPassword())) {
            model.addAttribute("error", "Nom d'utilisateur ou mot de passe incorrect.");
            return "login";
        }

        model.addAttribute("userrol", user.getRole());

        return "home";
    }

}
