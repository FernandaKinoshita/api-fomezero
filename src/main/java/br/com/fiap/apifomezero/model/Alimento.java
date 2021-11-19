package br.com.fiap.apifomezero.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_ALIMENTO")
public class Alimento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private double qtde;

	@ManyToOne
	private Doadora doadora;

	public Alimento() {
	}

	public Alimento(String nome, double qtde, Doadora doadora) {		
		this.nome = nome;
		this.qtde = qtde;
		this.doadora = doadora;
	}
}
