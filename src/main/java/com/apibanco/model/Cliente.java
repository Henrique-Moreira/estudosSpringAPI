package com.apibanco.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	@NotBlank(message = "O nome deve ser preenchido")
	private String nome;
	
	@Column(nullable = false)
	@NotBlank(message = "O email deve ser preenchido")
	@Pattern(regexp = "^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}$", message = "Formato de email incorreto.") //validar email. ex: exemplo@dominio.com
	private String email;
	
	@Column(nullable = false) 
	@NotBlank(message = "O cpf deve ser preenchido")
	@Pattern(regexp = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)", message = "0 cpf deve conter o formato ddd.ddd.ddd-dd") //validar cpf. ex: 111.222.333-44
	private String cpf;
	
	@Column(nullable = false)
	@NotBlank(message = "A data de nascimento deve ser preenchida")
	@Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "A data deve conter o formato aaaa-dd-mm") // intervalo entre 1900-01-01 e 2999-12-31
	private String dtNasc;
}
