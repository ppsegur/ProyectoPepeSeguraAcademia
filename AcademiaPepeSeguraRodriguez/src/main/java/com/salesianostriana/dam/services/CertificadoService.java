package com.salesianostriana.dam.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Certificado;

import base.BaseServiceImpl;

@Service
public class CertificadoService extends BaseServiceImpl<Certificado, Long, JpaRepository<Certificado,Long>> {

}
