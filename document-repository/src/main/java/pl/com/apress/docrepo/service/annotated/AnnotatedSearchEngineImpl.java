package pl.com.apress.docrepo.service.annotated;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.com.apress.docrepo.model.Document;
import pl.com.apress.docrepo.model.Type;
import pl.com.apress.docrepo.service.SearchEngine;
import pl.com.apress.docrepo.service.document.DocumentDao;

@Service("engine")
public class AnnotatedSearchEngineImpl implements SearchEngine {

	@Autowired
	private DocumentDao documentDao;

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
