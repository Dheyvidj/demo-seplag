package com.example.demo_seplag.service;

import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoService {

    private final MinioClient minioClient;

    @Value("${minio.bucket}")
    private String bucket;

    public FotoService(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    public void uploadFoto(MultipartFile file, String nomeObjeto) {
        try {
            boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
            if (!exists) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
            }
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucket)
                            .object(nomeObjeto)
                            .stream(file.getInputStream(), file.getSize(), -1)
                            .contentType(file.getContentType())
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar arquivo para o MinIO", e);
        }
    }

    public String getFotoUrlTemporario(String nomeObjeto) {
        try {
            return minioClient.getPresignedObjectUrl(
                    GetPresignedObjectUrlArgs.builder()
                            .bucket(bucket)
                            .object(nomeObjeto)
                            .method(Method.GET)
                            .expiry(300) // expira em 300 segundos (5 minutos)
                            .build()
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar URL temporária", e);
        }
    }
}
