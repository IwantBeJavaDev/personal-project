package pl.com.apress.docrepo.service.document;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pl.com.apress.docrepo.model.Document;
import pl.com.apress.docrepo.model.Type;

@Repository("documentDAO")
public class AnnotatedDocumentRepository implements DocumentDao {

	public Document[] getAllDocuments() {
		return storage();
	}

	private Document[] storage() {
		List<Document> result = new ArrayList<Document>();
		Type type = new Type();
		type.setName("PDF");
		type.setDesc("Portable Document Format");
		type.setExtension(".pdf");
		Document document = new Document();
		document.setName("Szablon książki");
		document.setType(type);
		document.setLocation("/Users/felipeg/Documents/Random/Book Template.pdf");
		result.add(document);

		document = new Document();
		document.setName("Przykładowa umowa");
		document.setType(type);
		document.setLocation("/Users/felipeg/Documents/Contracts/Sample Contract.pdf");
		result.add(document);
		type = new Type();
		type.setName("NOTE");
		type.setDesc("Notatki tekstowe");
		type.setExtension(".txt");
		document = new Document();
		document.setName("Clustering with RabbitMQ");
		document.setType(type);
		document.setLocation("/Users/felipeg/Documents/Random/Clustering with RabbitMQ.txt");
		result.add(document);

		type = new Type();
		type.setName("WEB");
		type.setDesc("Łącze sieciowe");
		type.setExtension(".url");
		document = new Document();
		document.setName("Pro Spring Security Book");
		document.setType(type);
		document.setLocation("http://www.apress.com/9781430248187");
		result.add(document);
		return result.toArray(new Document[result.size()]);
	}
}
