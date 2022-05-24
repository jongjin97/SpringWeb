package shop.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import shop.domain.UserDomain;
import shop.dto.RegisterRequest;
import shop.dto.User;
import shop.jpa.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;

	public UserDomain selectByEmail(String username) {
		//List<User> results = jdbc.query("select * from USER where email = ?", memRowMapper, email);
		UserDomain results = userRepository.findByEmail(username);
		return results == null ? null : results;
	}
	public List<UserDomain> selectAll(){
		//List<User> list = jdbc.query("select * from USER", memRowMapper);
		List<UserDomain> list = userRepository.findAll();
		return list.isEmpty() ? null : list;
	}
	
	public void insertUser(RegisterRequest registerRequest) {
		//jdbc.update("insert into USER(email, name, password) values (?, ?, ?)",
		//		registerRequest.getEmail(), registerRequest.getName(), registerRequest.getPassword());
		UserDomain userDomain = UserDomain.builder()
				.name(registerRequest.getName())
				.email(registerRequest.getEmail())
				.password(registerRequest.getPassword())
				.build();

		userRepository.save(userDomain);
	}
}
