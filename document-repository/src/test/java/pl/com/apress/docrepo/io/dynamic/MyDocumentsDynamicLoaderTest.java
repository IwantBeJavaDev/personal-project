package pl.com.apress.docrepo.io.dynamic;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.com.apress.docrepo.spring.io.ResourcesLoaderMenu;

public class MyDocumentsDynamicLoaderTest {
	private static final Logger log = LoggerFactory.getLogger(MyDocumentsDynamicLoaderTest.class);
	private ClassPathXmlApplicationContext context;

	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("io/mydocuments-injection-context.xml");
	}

	@Test
	public void testMenu() {
		log.debug("Wczytywanie pliku zasobów: menu.txt");
		ResourcesLoaderMenu menu = context.getBean(ResourcesLoaderMenu.class);
		assertNotNull(menu);

		menu.printMenu("classpath:io/menu.txt");
	}
}
