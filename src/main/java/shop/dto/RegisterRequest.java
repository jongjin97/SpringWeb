package shop.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import shop.domain.UserDomain;

@Getter
@NoArgsConstructor
public class RegisterRequest{

	private String name;
	private String email;
	private String password;
	private String confirm;


	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	
	public UserDomain toEntity(){
		return UserDomain.builder()
				.name(name)
				.email(email)
				.password(password)
				.build();
	}

	@Builder
	public RegisterRequest(String name, String email, String password, String confirm){
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirm = confirm;
	}
}
