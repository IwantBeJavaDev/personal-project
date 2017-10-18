package pl.com.apress.docrepo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.com.apress.docrepo.model.Document;
import pl.com.apress.docrepo.model.Type;

public class MyDocumentsTest {
	private ClassPathXmlApplicationContext context;
	private SearchEngine engine;
	private Type documentType;

	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("mydocuments-context.xml");
		engine = context.getBean(SearchEngine.class);
		documentType = context.getBean(Type.class);
	}

	@Test
	public void testFindByType() {

		List<Document> documents = engine.findByType(documentType);

		assertNotNull(documents);
		assertTrue(documents.size() == 1);
		assertEquals(documentType.getName(), documents.get(0).getType().getName());
		assertEquals(documentType.getDesc(), documents.get(0).getType().getDesc());
		assertEquals(documentType.getExtension(), documents.get(0).getType().getExtension());
	}

	@Test
	public void testListAll() {
		List<Document> documents = engine.listAll();
		assertNotNull(documents);
		assertTrue(documents.size() == 1);
	}
}
