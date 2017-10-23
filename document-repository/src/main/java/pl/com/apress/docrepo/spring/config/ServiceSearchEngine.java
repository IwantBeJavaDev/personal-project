package pl.com.apress.docrepo.spring.config;

import java.util.List;

import pl.com.apress.docrepo.model.Document;
import pl.com.apress.docrepo.model.Type;
import pl.com.apress.docrepo.service.document.DocumentDao;

public interface ServiceSearchEngine {
	public List<Document> findByType(Type documentType);

	public List<Document> listAll();

	public void setDocumentDao(DocumentDao documentDao);

}
