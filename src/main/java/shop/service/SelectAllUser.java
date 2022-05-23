package shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shop.dao.UserDao;
import shop.domain.UserDomain;
import shop.dto.User;

@Service
public class SelectAllUser {
	@Autowired
	private UserDao userDao;
	
	public List<UserDomain> SelectAll(){
		List<UserDomain> list = userDao.selectAll();
		System.out.println(list.size());
		return list;
	}
	
}
