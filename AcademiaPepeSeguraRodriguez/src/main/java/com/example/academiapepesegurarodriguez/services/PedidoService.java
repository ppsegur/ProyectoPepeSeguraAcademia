package com.example.academiapepesegurarodriguez.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.academiapepesegurarodriguez.base.BaseServiceImpl;
import com.example.academiapepesegurarodriguez.model.Pedido;

@Service
public class PedidoService  extends BaseServiceImpl<Pedido, Long, JpaRepository<Pedido,Long>>{

}
