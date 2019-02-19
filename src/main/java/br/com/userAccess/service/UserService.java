package br.com.userAccess.service;

import java.util.List;

import br.com.userAccess.domain.User;

/**
 * @Author Marcelo Nascimento
 * @Date 18 de fev de 2019
 * @Project user-access
 * @Package br.com.userAccess.service
 * @Desc Interface to contract to User.
 */
public interface UserService {

	/**
	 * @return
	 * @Author Marcelo Nascimento
	 * @Date 18 de fev de 2019
	 * @Project user-access
	 * @Package br.com.userAccess.service
	 * @Desc List all users.
	 */
	List<User> all();

}
