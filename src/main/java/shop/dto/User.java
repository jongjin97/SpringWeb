package shop.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import shop.entity.UserDomain;

@Getter
@Setter
@NoArgsConstructor
public class User {
	private long id;
	private String name;
	private String email;
	private String password;

	@Builder
	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

}
