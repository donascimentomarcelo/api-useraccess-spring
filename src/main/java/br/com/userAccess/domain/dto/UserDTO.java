package br.com.userAccess.domain.dto;

import java.io.Serializable;

import br.com.userAccess.domain.User;

/**
 * @Author Marcelo Nascimento
 * @Date 18 de fev de 2019
 * @Project user-access
 * @Package br.com.userAccess.domain.dto
 * @Desc 
 */
public class UserDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String nameAndEmail;
	
	public UserDTO() {
		super();
	}
	
	public UserDTO(User user) {
		super();
		this.username = user.getUsername();
		this.nameAndEmail = user.getClient().getName() + " - " + user.getClient().getEmail();
	}
	
	public UserDTO(String username, String nameAndEmail) {
		super();
		this.username = username;
		this.nameAndEmail = nameAndEmail;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNameAndEmail() {
		return nameAndEmail;
	}
	public void setNameAndEmail(String nameAndEmail) {
		this.nameAndEmail = nameAndEmail;
	}
	
	

}
