package com.Sberbank.RostovDitTast.Controller;

import com.Sberbank.RostovDitTast.Entity.Document;
import com.Sberbank.RostovDitTast.Service.DocumentService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author Евгений
 * @project RostovDitTast
 */

@Controller
@NoArgsConstructor
public class DocumentController {

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    DocumentService documentService;
    @PostMapping(value = "/createDocument")
    public ResponseEntity<Boolean> createDocument(@RequestBody Document document){
        System.out.println(document);
        return ResponseEntity.ok(documentService.createDocument(document.getName(),document.getBox()));
    }
}
