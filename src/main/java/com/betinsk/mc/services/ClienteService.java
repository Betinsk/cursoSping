package com.betinsk.mc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.betinsk.mc.domain.Cliente;
import com.betinsk.mc.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository categoriaRepository;
	

	
	public Cliente find(Integer id) { 
		 Optional<Cliente> obj = categoriaRepository.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName())); 
		}
	
}
