package shop.dto;


import com.sun.istack.NotNull;
import lombok.Builder;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.entity.UserDomain;

@Data
@NoArgsConstructor
public class RegisterRequest{
	@NotNull
	private String name;
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String confirm;

	
//	public UserDomain toEntity(){
//		return UserDomain.builder()
//				.name(name)
//				.email(email)
//				.password(password)
//				.build();
//	}
}
