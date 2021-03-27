package br.com.msclientes.model.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TB_SERVICO")
@Data
public class Servico implements Serializable{
	private static final long serialVersionUID = -5067969073818170583L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String descricao;
	
	@Column
	private BigDecimal preco;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

}
