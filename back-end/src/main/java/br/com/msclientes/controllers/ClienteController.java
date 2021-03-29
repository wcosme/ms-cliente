package br.com.msclientes.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.msclientes.model.entities.Cliente;
import br.com.msclientes.model.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository repository;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Cliente save(@Valid @RequestBody Cliente cliente) {
		return repository.save(cliente);
	}
	
	@GetMapping("{id}")
	public Cliente findById(@PathVariable Long id) {
		return repository
				.findById(id)
				.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		repository
				.findById(id)
				.map(cliente -> {
					repository.delete(cliente);
					return Void.TYPE;
				})
				.orElseThrow( ()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
	}
	
	@PutMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @Valid @RequestBody Cliente clienteUpdate) {
		repository
			.findById(id)
			.map(cliente -> {
				clienteUpdate.setId(cliente.getId());
				return repository.save(clienteUpdate);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

	}

}
