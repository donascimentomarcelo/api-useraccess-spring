package br.com.userAccess.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String login;
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="user")
	@JsonIgnore
	private Client client;

	public User() {
		super();
	}

	public User(Integer id, String login, String password, Client client) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	
}
