package br.com.msclientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msclientes.model.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
