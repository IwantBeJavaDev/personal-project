package pl.com.apress.docrepo.io.loggin;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.com.apress.docrepo.spring.loggin.LoginService;

public class MyDocumentsLoginTest {
	private static final Logger log = LoggerFactory.getLogger(MyDocumentsLoginTest.class);
	private ClassPathXmlApplicationContext context;

	private static final String EMAIL = "test@mydocuments.com";
	private static final String PASS = "test123";
	private static final String SUCCESS = "Ten użytkownik ma autoryzację";
	private static final String FAILURE = "UWAGA! Ten użytkownik nie ma autoryzacji!";

	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("loggin/mydocuments-login-context.xml");
	}

	@Test
	public void testMenu() {
		log.debug("Test logowania");
		LoginService login = context.getBean(LoginService.class);
		assertNotNull(login);

		if (login.isAuthorization(EMAIL, PASS))
			System.out.println(SUCCESS);
		else
			System.out.println(FAILURE);

	}
}
