package com.salesianostriana.dam.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Pedido;

import base.BaseServiceImpl;

@Service
public class PedidoService  extends BaseServiceImpl<Pedido, Long, JpaRepository<Pedido,Long>>{

}
