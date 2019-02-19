package br.com.userAccess.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<?> show() {
		List<User> list = userService.all();
		List<UserConcatLoginEndName> newList = list.stream().map(u -> new UserConcatLoginEndName(u)).collect(Collectors.toList());
 		return ResponseEntity.ok(newList);
	}
}
