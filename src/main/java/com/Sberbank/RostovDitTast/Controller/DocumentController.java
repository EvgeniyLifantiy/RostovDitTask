package com.Sberbank.RostovDitTast.Controller;

import com.Sberbank.RostovDitTast.Entity.Box;
import com.Sberbank.RostovDitTast.Entity.Document;
import com.Sberbank.RostovDitTast.Service.BoxService;
import com.Sberbank.RostovDitTast.Service.DocumentService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author Евгений
 * @project RostovDitTast
 */

@Controller
public class DocumentController {

    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping(value = "/createDocument")
    public ResponseEntity<Document> createDocument(@RequestBody Map<String,String> map){
        return ResponseEntity.ok(documentService.create(map));
    }
}
