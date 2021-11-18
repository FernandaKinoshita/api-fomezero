package br.com.fiap.apifomezero.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Data;

@Data
@Entity
@Table(name = "TB_DOADORA")
public class Doadora implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@CNPJ
	@Column(nullable = false, unique = true)
	private String cnpj;

	@Column(nullable = false, length = 50)
	private String razaoSocial;

	@Column(nullable = false, length = 50)
	private String endereco;

	@Column(nullable = false, length = 50)
	private String telefone;

	@Email
	@Column(nullable = false, length = 40, unique = true)
	private String email;

	@Column(nullable = false)
	private String senha;

	// Construtor
	public Doadora() {
	}

	public Doadora(@CNPJ String cnpj, String razaoSocial, String endereco, String telefone, @Email String email,
			String senha) {
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.senha = senha;
	}

}
