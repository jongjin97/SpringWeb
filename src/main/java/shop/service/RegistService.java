package shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.UserDao;
import shop.domain.UserDomain;
import shop.dto.RegisterRequest;
import shop.dto.User;
import shop.exception.DuplicateMemberException;

@Service
public class RegistService {
	@Autowired
	private UserDao userDao;
	
	public void registService(RegisterRequest registerRequest) {
		UserDomain user = userDao.selectByEmail(registerRequest.getEmail());
		if(user != null) {
			throw new DuplicateMemberException("duplicate email : " + registerRequest.getEmail());
		} else {
			userDao.insertUser(registerRequest);
		}
	}
}
