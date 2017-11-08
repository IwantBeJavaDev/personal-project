package pl.com.apress.docrepo.spring.loggin;

public interface LoginService {
	public boolean isAuthorization(String login, String passwd);
}
