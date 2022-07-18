package com.betinsk.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betinsk.mc.domain.Pedido;
import com.betinsk.mc.repositories.PedidoRepository;
import com.betinsk.mc.resources.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository clienteRepository;
	

	
	public Pedido find(Integer id) { 
		 Optional<Pedido> obj = clienteRepository.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())); 
		}
	
}
