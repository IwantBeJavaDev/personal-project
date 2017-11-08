package pl.com.apress.docrepo.io.lang;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyDocumentsLangTest {
	private static final Logger log = LoggerFactory.getLogger(MyDocumentsLangTest.class);
	private ClassPathXmlApplicationContext context;

	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("lang/mydocuments-context.xml");
	}

	@Test
	public void testMenu() {
		log.debug("Do przetłumaczenia...");
		String polish = context.getMessage("main.title", null, new Locale("pl"));
		String spanish = context.getMessage("main.title", null, new Locale("es"));
		System.out.println("Polski: " + polish);
		System.out.println("Spanish: " + spanish);
	}
}
