package pl.com.apress.docrepo.spring.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pl.com.apress.docrepo.model.Document;
import pl.com.apress.docrepo.model.Type;
import pl.com.apress.docrepo.service.document.DocumentDao;

public class ServiceSearchEngineImpl implements ServiceSearchEngine {

	private DocumentDao documentDao;

	public DocumentDao getDocumentDao() {
		return documentDao;
	}

	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	public List<Document> findByType(Type documentType) {
		List<Document> result = new ArrayList<Document>();
		for (Document document : listAll()) {
			if (document.getType().getName().equals(documentType.getName()))
				result.add(document);
		}
		return result;
	}

	public List<Document> listAll() {
		return Arrays.asList(documentDao.getAllDocuments());
	}

}
