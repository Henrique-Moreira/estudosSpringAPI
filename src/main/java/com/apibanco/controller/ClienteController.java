package com.apibanco.controller;

import java.util.List;

import javax.validation.Valid;
import javax.xml.bind.TypeConstraintException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apibanco.model.Cliente;
import com.apibanco.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;

	@GetMapping
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente adicionar(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	//@PostMapping
	//@ResponseStatus(HttpStatus.CREATED)
	//public Cliente adicionar(@Valid @RequestBody Cliente cliente, BindingResult br) {
	//	if(br.hasErrors()) {
	//		throw new TypeConstraintException(br.getAllErrors().get(0).getDefaultMessage());
	//	} else {
	//		return clienteRepository.save(cliente);	
	//	}
	//}
}