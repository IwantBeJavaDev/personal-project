package pl.com.apress.docrepo.spring.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.com.apress.docrepo.model.Document;
import pl.com.apress.docrepo.model.Type;
import pl.com.apress.docrepo.service.document.DocumentDao;
import pl.com.apress.docrepo.service.document.DocumentRepository;

@Configuration
public class MyDocumentsContext {

	private Map<String, Document> documents = new HashMap<String, Document>();
	private Map<String, Type> types = new HashMap<String, Type>();

	@Bean
	public Type webType() {
		return getTypeFromMap("web");
	}

	@Bean
	public ServiceSearchEngine engine() {
		ServiceSearchEngine engine = new ServiceSearchEngineImpl();
		engine.setDocumentDao(documentDAO());
		return engine;
	}

	public MyDocumentsContext() {
		createTypeDocs();
		createDocuments();

	}

	private void createDocuments() {
		Document document = new Document();
		document.setName("Szablon książki");
		document.setType(types.get("pdf"));
		document.setLocation("/Users/felipeg/Documents/Random/Book Template.pdf");
		documents.put("doc1", document);

		document = new Document();
		document.setName("Przykładowa umowa");
		document.setType(types.get("pdf"));
		document.setLocation("/Users/felipeg/Documents/Contracts/Sample Contract.pdf");
		documents.put("doc2", document);

		document = new Document();
		document.setName("Clustering with RabbitMQ");
		document.setType(types.get("note"));
		document.setLocation("/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");
		documents.put("doc3", document);

		document = new Document();
		document.setName("Pro Spring Security Book");
		document.setType(types.get("web"));
		document.setLocation("http://www.apress.com/9781430248187");
		documents.put("doc4", document);

	}

	private void createTypeDocs() {
		Type type = new Type();
		type.setName("PDF");
		type.setDesc("Portable Document Format");
		type.setExtension(".pdf");
		types.put("pdf", type);

		type = new Type();
		type.setName("NOTE");
		type.setDesc("Notatki tekstowe");
		type.setExtension(".txt");
		types.put("note", type);

		type = new Type();
		type.setName("WEB");
		type.setDesc("Łącze sieciowe");
		type.setExtension(".url");
		types.put("web", type);

	}

	private DocumentDao documentDAO() {
		DocumentRepository documentDAO = new DocumentRepository();
		documentDAO.setDoc1(getDocumentFromMap("doc1"));
		documentDAO.setDoc2(getDocumentFromMap("doc2"));
		documentDAO.setDoc3(getDocumentFromMap("doc3"));
		documentDAO.setDoc4(getDocumentFromMap("doc4"));
		return documentDAO;
	}

	private Document getDocumentFromMap(String documentKey) {
		return documents.get(documentKey);
	}

	private Type getTypeFromMap(String typeKey) {
		return types.get(typeKey);
	}
}
