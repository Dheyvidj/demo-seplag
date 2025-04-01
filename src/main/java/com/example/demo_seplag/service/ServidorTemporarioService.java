package com.example.demo_seplag.service;

import com.example.demo_seplag.entity.ServidorTemporario;
import com.example.demo_seplag.exception.NotFoundException;
import com.example.demo_seplag.repository.ServidorTemporarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServidorTemporarioService {

    @Autowired
    private ServidorTemporarioRepository repository;
    
    public List<ServidorTemporario> listAll() {
        return repository.findAll();
    }
    
    public ServidorTemporario getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Servidor temporário não encontrado"));
    }
    
    public ServidorTemporario create(ServidorTemporario st) {
        return repository.save(st);
    }
    
    public ServidorTemporario update(Long id, ServidorTemporario stUpdate) {
        ServidorTemporario st = getById(id);
        st.setStDataInicio(stUpdate.getStDataInicio());
        st.setStDataFim(stUpdate.getStDataFim());
        st.setPessoa(stUpdate.getPessoa());
        return repository.save(st);
    }
    
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
