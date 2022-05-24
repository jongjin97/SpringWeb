package shop.dto;


import shop.domain.UserDomain;

public class RegisterRequest{

	private String name;
	private String email;
	private String password;
	private String confirm;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirm() {
		return confirm;
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
}
