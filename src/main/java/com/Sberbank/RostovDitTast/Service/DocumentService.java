package com.Sberbank.RostovDitTast.Service;

import com.Sberbank.RostovDitTast.Entity.Box;
import com.Sberbank.RostovDitTast.Entity.Document;
import com.Sberbank.RostovDitTast.Repository.BoxRepository;
import com.Sberbank.RostovDitTast.Repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Евгений
 * @project RostovDitTast
 */
@Service
public class DocumentService {

    private final DocumentRepository docRepository;
    private final BoxRepository boxRepository;

    @Autowired
    public DocumentService(DocumentRepository docRepository, BoxRepository boxRepository) {
        this.docRepository = docRepository;
        this.boxRepository = boxRepository;
    }

    public List<Document> getAll() {
        return docRepository.findAll();
    }

    public Document update(Document doc) {
        Document document = docRepository.getById(doc.getId());
        document.setBarcode(doc.getBarcode());
        document.setName(doc.getName());
        return document;
    }

    public Document getById(Long id) {
        Document document=docRepository.getById(id);
        Box box=document.getBox();
        box.getDocuments().remove(document);
        boxRepository.save(box);
        return docRepository.getById(id);
    }

    public void delete(Long id) {
        docRepository.deleteById(id);
    }

    @Transactional
    public Document create(Map<String,String> jsonRequest) {
        //initialize
        long boxId = Long.parseLong(jsonRequest.get("boxId"));
        String docName = jsonRequest.get("name");

        Box box=boxRepository.getById(boxId);
        List<Document> list=box.getDocuments();



        Document document=new Document(docName,box);
        list.add(document);

        box.setDocuments(list);

        return document;
    }
}
