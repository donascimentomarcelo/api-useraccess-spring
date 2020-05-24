package br.com.userAccess.serviceImpl;

import br.com.userAccess.config.security.UserSpringSecurity;
import br.com.userAccess.domain.User;
import br.com.userAccess.exception.ObjectNotFoundException;
import br.com.userAccess.repository.UserRepository;
import br.com.userAccess.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@Override
	public List<User> all() {
		return userRepository.findAll();
	}

	@Override
	public Page<User> paginateUser(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return userRepository.findAll(pageRequest);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username)
					.orElseThrow(() -> new ObjectNotFoundException("username not found!"));
	}

	@Override
	public UserSpringSecurity authenticated() {
		try {
			return (UserSpringSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}
}
