package com.Sberbank.RostovDitTast.Controller;

import com.Sberbank.RostovDitTast.Entity.Box;
import com.Sberbank.RostovDitTast.Entity.Document;
import com.Sberbank.RostovDitTast.Service.BoxService;
import com.Sberbank.RostovDitTast.Service.DocumentService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author Евгений
 * @project RostovDitTast
 */

@Controller("/api/document")
public class DocumentController {

    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Document> createDocument(@RequestBody Map<String,String> map){
        return ResponseEntity.ok(documentService.create(map));
    }

    @GetMapping("/get")
    public ResponseEntity<List<Document>> getAllDocuments(){
        return ResponseEntity.ok(documentService.getAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id){
        return ResponseEntity.ok(documentService.getById(id));
    }

    @PutMapping("/update")
    public ResponseEntity<Document> updateDocument(@RequestBody Document document){
        return ResponseEntity.ok(documentService.update(document));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDocument(@PathVariable Long id) {
        documentService.delete(id);
    }
}
