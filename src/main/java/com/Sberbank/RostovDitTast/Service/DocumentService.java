package com.Sberbank.RostovDitTast.Service;

import com.Sberbank.RostovDitTast.Entity.Document;
import com.Sberbank.RostovDitTast.Repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Евгений
 * @project RostovDitTast
 */
@Service
public class DocumentService {

    DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public boolean createDocument(String name){
        documentRepository.save(new Document(name));
        return true;
    }
}
