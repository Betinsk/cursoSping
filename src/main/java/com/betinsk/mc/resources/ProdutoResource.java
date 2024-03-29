package com.betinsk.mc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.betinsk.mc.domain.Produto;
import com.betinsk.mc.dto.ProdutoDTO;
import com.betinsk.mc.resources.utils.URL;
import com.betinsk.mc.services.ProdutoService;

@RestController
@RequestMapping(value ="/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService  produtoService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id) {
		Produto obj = produtoService.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//Method findAll
		@RequestMapping(value="page", method=RequestMethod.GET)
		public ResponseEntity<Page<ProdutoDTO>> findPage(
			@RequestParam(value="name", defaultValue="") String nome,
			@RequestParam(value="categorias", defaultValue="") String categorias,
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
			String nomeDecoded = URL.decodeParam(nome);
			List<Integer> ids = URL.decodeInList(categorias);
			
			Page<Produto> list = produtoService.search(nomeDecoded, ids,  page,  linesPerPage,  orderBy, direction);
			Page<ProdutoDTO> listDto = list.map(obj -> new ProdutoDTO(obj));
			return ResponseEntity.ok().body(listDto);
		}
}
