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
public class UserConcatLoginEndName implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String login;
	private String nameAndEmail;
	
	public UserConcatLoginEndName() {
		super();
	}
	
	public UserConcatLoginEndName(User user) {
		super();
		this.login = user.getLogin();
		this.nameAndEmail = user.getClient().getNome() + " - " + user.getClient().getEmail();
	}
	
	public UserConcatLoginEndName(String login, String nameAndEmail) {
		super();
		this.login = login;
		this.nameAndEmail = nameAndEmail;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNameAndEmail() {
		return nameAndEmail;
	}
	public void setNameAndEmail(String nameAndEmail) {
		this.nameAndEmail = nameAndEmail;
	}
	
	

}
