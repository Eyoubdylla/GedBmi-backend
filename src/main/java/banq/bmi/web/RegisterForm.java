package banq.bmi.web;

import banq.bmi.entities.Role;

public class RegisterForm {
	private String username ;
	private String password ;
	private String repassword ;
	private String email ;
	private Role role;


	public RegisterForm(String username, String password, String repassword, String email, Role role) {
		super();
		this.username = username;
		this.email = email ;
		this.password = password;
		this.repassword = repassword;
		this.role = role;
	}


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
