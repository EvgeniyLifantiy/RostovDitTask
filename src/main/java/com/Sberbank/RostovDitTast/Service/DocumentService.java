package com.Sberbank.RostovDitTast.Service;

import com.Sberbank.RostovDitTast.Entity.Box;
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

    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public boolean createDocument(String name, Box box){
        documentRepository.save(new Document(name,box));
        return true;
    }
}
