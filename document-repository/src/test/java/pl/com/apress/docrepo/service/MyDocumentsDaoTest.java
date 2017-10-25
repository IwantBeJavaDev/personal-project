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
import pl.com.apress.docrepo.spring.config.ServiceSearchEngine;

public class MyDocumentsDaoTest {
	private ClassPathXmlApplicationContext context;
	private ServiceSearchEngine engine;
	private Type webType;

	@Before
	public void setup() {
		context = new ClassPathXmlApplicationContext("mydocumentsDao-context.xml");
		engine = context.getBean(ServiceSearchEngine.class);
		webType = context.getBean("webType", Type.class);
	}

	@Test
	public void testFindByType() {

		List<Document> documents = engine.findByType(webType);

		assertNotNull(documents);
		assertTrue(documents.size() == 1);
		assertEquals(webType.getName(), documents.get(0).getType().getName());
		assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
		assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());
	}

	@Test
	public void testListAll() {
		engine = context.getBean(ServiceSearchEngine.class);
		webType = context.getBean("webType", Type.class);
		List<Document> documents = engine.findByType(webType);

		assertNotNull(documents);
		assertTrue(documents.size() == 1);
		assertEquals(webType.getName(), documents.get(0).getType().getName());
		assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
		assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());

		engine = context.getBean(ServiceSearchEngine.class);
		documents = engine.listAll();

		assertNotNull(documents);
		assertTrue(documents.size() == 4);
	}
}
