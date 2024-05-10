package com.example.academiapepesegurarodriguez.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.academiapepesegurarodriguez.base.BaseServiceImpl;
import com.example.academiapepesegurarodriguez.model.Certificado;

@Service
public class CertificadoService extends BaseServiceImpl<Certificado, Long, JpaRepository<Certificado,Long>> {

}
