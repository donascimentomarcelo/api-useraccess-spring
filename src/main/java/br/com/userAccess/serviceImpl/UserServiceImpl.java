package br.com.userAccess.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.userAccess.domain.User;
import br.com.userAccess.repository.UserRepository;
import br.com.userAccess.service.UserService;

/**
 * @Author Marcelo Nascimento
 * @Date 18 de fev de 2019
 * @Project user-access
 * @Package br.com.userAccess.service
 * @Desc This class has the rules about User. 
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	/* (non-Javadoc)
	 * @see br.com.userAccess.service.UserService#all()
	 * @return
	 * @Project user-access
	 * @Author Marcelo Nascimento
	 * @Date 18:49:41
	 */
	@Override
	public List<User> all() {
		return userRepository.findAll();
	}
	
	/* (non-Javadoc)
	 * @see br.com.userAccess.service.UserService#paginateUser(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String)
	 * @param page
	 * @param linesPerPage
	 * @param orderBy
	 * @param direction
	 * @return
	 * @Project user-access
	 * @Author Marcelo Nascimento
	 * @Date 22:39:50
	 */
	@Override
	public Page<User> paginateUser(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return userRepository.findAll(pageRequest);
	}
	

}
