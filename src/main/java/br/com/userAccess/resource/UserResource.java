package br.com.userAccess.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.userAccess.domain.User;
import br.com.userAccess.domain.dto.UserConcatLoginEndName;
import br.com.userAccess.service.UserService;

/**
 * @Author Marcelo Nascimento
 * @Date 13 de fev de 2019
 * @Project user-access
 * @Package resource
 * @Desc Resources to define end points to user.
 */

@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserService userService; 
	@GetMapping
	public ResponseEntity<List<UserConcatLoginEndName>> show() {
		List<User> list = userService.all();
		List<UserConcatLoginEndName> newList = list.stream().map(u -> new UserConcatLoginEndName(u)).collect(Collectors.toList());
 		return ResponseEntity.ok(newList);
	}
	
	@GetMapping("/paginate")
	public ResponseEntity<?> paginate(			
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "login") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "DESC")String direction) {
		Page<User> list = userService.paginateUser(page, linesPerPage, orderBy, direction);
		Page<UserConcatLoginEndName> newList = list.map(u -> new UserConcatLoginEndName(u));
		return ResponseEntity.ok(newList);
	}
}
