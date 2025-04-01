package com.example.demo_seplag.service;

import com.example.demo_seplag.dto.AuthRequest;
import com.example.demo_seplag.dto.AuthResponse;
import com.example.demo_seplag.entity.Usuario;
import com.example.demo_seplag.exception.BadRequestException;
import com.example.demo_seplag.exception.NotFoundException;
import com.example.demo_seplag.repository.UsuarioRepository;
import com.example.demo_seplag.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public AuthResponse login(AuthRequest request) {
        Usuario usuario = usuarioRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
        if (passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            String accessToken = JwtUtil.generateAccessToken(usuario.getUsername());
            String refreshToken = JwtUtil.generateRefreshToken(usuario.getUsername());
            return new AuthResponse(accessToken, refreshToken);
        } else {
            throw new BadRequestException("Credenciais inválidas");
        }
    }

    public AuthResponse refresh(Map<String, String> request) {
        String refreshToken = request.get("refreshToken");
        try {
            String username = JwtUtil.getUsernameFromToken(refreshToken);
            String newAccessToken = JwtUtil.generateAccessToken(username);
            String newRefreshToken = JwtUtil.generateRefreshToken(username);
            return new AuthResponse(newAccessToken, newRefreshToken);
        } catch (Exception e) {
            throw new BadRequestException("Refresh token inválido ou expirado");
        }
    }
}
