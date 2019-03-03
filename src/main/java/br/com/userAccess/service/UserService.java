package br.com.userAccess.service;

import java.util.List;

import org.springframework.data.domain.Page;

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

	/**
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return
	 * @Author Marcelo Nascimento
	 * @Date 18 de fev de 2019
	 * @Project user-access
	 * @Package br.com.userAccess.service
	 * @Desc Return users paginated.
	 */
	Page<User> paginateUser(Integer page, Integer linesPerPage, String orderBy, String direction);

}
