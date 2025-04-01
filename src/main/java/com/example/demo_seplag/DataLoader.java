package com.example.demo_seplag;

import com.example.demo_seplag.entity.Usuario;
import com.example.demo_seplag.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (usuarioRepository.findByUsername("admin").isEmpty()) {
            Usuario usuario = new Usuario();
            usuario.setUsername("admin");
            usuario.setPassword(passwordEncoder.encode("admin"));
            usuarioRepository.save(usuario);
        }
    }
}
