package pl.com.apress.docrepo.service;

import java.util.List;

import pl.com.apress.docrepo.model.Document;
import pl.com.apress.docrepo.model.Type;

public interface SearchEngine {
	public List<Document> findByType(Type documentType);
	public List<Document> listAll();
}
