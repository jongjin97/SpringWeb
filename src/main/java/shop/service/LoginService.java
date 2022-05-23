package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.UserDao;
import shop.domain.UserDomain;
import shop.dto.User;
import shop.exception.WrongIdPasswordException;

@Service
public class LoginService {
	@Autowired
	private UserDao userDao;
	
	public UserDomain login(String email, String password) {
		UserDomain user = userDao.selectByEmail(email);
		if(user == null || !user.getPassword().equals(password))
			throw new WrongIdPasswordException();
		
		return user;
	}
}
