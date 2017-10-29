package pl.com.apress.docrepo.io;

import java.io.InputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class MyDocumentsTest {
	private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
	private ClassPathXmlApplicationContext context;

	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("io/mydocuments-context.xml");
	}

	@Test
	public void testMenu() {
		log.debug("Wczytywanie pliku zasobów: menu.txt");
		Resource resource = context.getResource("classpath:io/menu.txt");
		try {
			InputStream stream = resource.getInputStream();
			Scanner scanner = new Scanner(stream);
			while (scanner.hasNext()) {
				System.out.println(scanner.nextLine());
			}
			scanner.close();
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
