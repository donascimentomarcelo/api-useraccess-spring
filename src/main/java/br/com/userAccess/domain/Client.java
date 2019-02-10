package br.com.userAccess.domain;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String email;
	private String nome;
	private String cpf;
	private String sexo;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;

	public Client() {
		super();
	}

	public Client(String email, String nome, String cpf, String sexo, User user) {
		super();
		this.email = email;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
