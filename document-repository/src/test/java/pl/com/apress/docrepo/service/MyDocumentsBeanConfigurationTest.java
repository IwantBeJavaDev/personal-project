package pl.com.apress.docrepo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.com.apress.docrepo.model.Document;
import pl.com.apress.docrepo.model.Type;
import pl.com.apress.docrepo.spring.config.MyDocumentsContext;
import pl.com.apress.docrepo.spring.config.ServiceSearchEngine;

public class MyDocumentsBeanConfigurationTest {

	private ApplicationContext context;
	private ServiceSearchEngine engine;
	private Type webType;

	@Before
	public void setup() {
		context = new AnnotationConfigApplicationContext(MyDocumentsContext.class);
		engine = context.getBean(ServiceSearchEngine.class);
		webType = context.getBean(Type.class);
	}

	@Test
	public void testWithBeanConfigurationFindByType() {
		List<Document> documents = engine.findByType(webType);
		assertNotNull(documents);
		assertTrue(documents.size() == 1);
		assertEquals(webType.getName(), documents.get(0).getType().getName());
		assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
		assertEquals(webType.getExtension(), documents.get(0).getType().getExtension());
	}

	@Test
	public void testWithBeanConfigurationListAll() {
		List<Document> documents = engine.listAll();
		assertNotNull(documents);
		assertTrue(documents.size() == 4);
	}
}
