package com.example.demo_seplag.controller;

import com.example.demo_seplag.entity.FotoPessoa;
import com.example.demo_seplag.service.FotoPessoaService;
import com.example.demo_seplag.service.FotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/fotos")
public class FotoController {

    @Autowired
    private FotoService fotoService;

    @Autowired
    private FotoPessoaService fotoPessoaService;

    // Se quiser, injete o bucket via @Value para salvar no campo fp_bucket
    @Value("${minio.bucket}")
    private String bucket;

    @PostMapping("/upload")
    public String uploadFoto(@RequestParam("foto") MultipartFile foto,
                             @RequestParam("pessoaId") Long pessoaId) {

        // Gera o nome do objeto no MinIO
        String nomeObjeto = "pessoa-" + pessoaId + "-" + System.currentTimeMillis();

        // Faz upload da foto
        fotoService.uploadFoto(foto, nomeObjeto);

        // Cria registro na tabela foto_pessoa
        FotoPessoa fotoPessoa = new FotoPessoa();
        fotoPessoa.setPesId(pessoaId);
        fotoPessoa.setFpData(LocalDate.now());
        fotoPessoa.setFpBucket(bucket);
        fotoPessoa.setFpHash(nomeObjeto);

        fotoPessoaService.saveFotoPessoa(fotoPessoa);

        return "Foto enviada com sucesso: " + nomeObjeto;
    }

    @GetMapping("/url-temporaria")
    public String getUrlTemporaria(@RequestParam("nomeObjeto") String nomeObjeto) {
        return fotoService.getFotoUrlTemporario(nomeObjeto);
    }
}
