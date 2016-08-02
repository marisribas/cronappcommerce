package auth.permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import security.business.UserBusiness;
import security.entity.User;

/**
 * Controller responsável por gerir a troca de
 * senha do usuário através de serviço REST
 * 
 * @author Techne
 *
 */
@RestController
@RequestMapping(value = "/changePassword")
@PreAuthorize("hasRole('Logged')")
public class ChangePassword {

	@Autowired
	@Qualifier("UserBusiness")
	private UserBusiness userBusiness;

	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public User post(final String oldPassword, final String newPassword, final String newPasswordConfirmation)
			throws Exception {

		if (!newPassword.equals(newPasswordConfirmation))
			throw new RuntimeException("Senha de confirmação diferente");

		org.springframework.security.core.userdetails.User userDetails = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();

		Page<User> users = userBusiness.findByLogin(userDetails.getUsername(), new PageRequest(0, 100));
		if (users.getContent().size() > 0) {
		//	Page user = users.getContent().get(0);

			if (!passwordEncoder.matches(oldPassword, users.getContent().get(0).getPassword()))
				throw new RuntimeException("Senha anterior não confere!");

			users.getContent().get(0).setPassword(passwordEncoder.encode(newPassword));
			userBusiness.put(users.getContent().get(0));
			return users.getContent().get(0);
		}

		throw new RuntimeException("Usuario não encontrado!");
	}
}