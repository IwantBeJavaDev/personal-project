package pl.com.apress.docrepo.spring.loggin;

public class LoginServiceImpl implements LoginService {

	private String login;
	private String password;

	public boolean isAuthorization(String login, String passwd) {
		if (this.login.equals(login) && this.password.equals(passwd)) {
			return true;
		}
		return false;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
