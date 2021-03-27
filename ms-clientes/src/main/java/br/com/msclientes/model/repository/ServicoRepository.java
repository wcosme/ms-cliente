package br.com.msclientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.msclientes.model.entities.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long>{

}
