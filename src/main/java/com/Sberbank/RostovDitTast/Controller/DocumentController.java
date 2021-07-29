package com.Sberbank.RostovDitTast.Controller;

import com.Sberbank.RostovDitTast.Service.DocumentService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    @PostMapping("/createDocument/{name}")
    public String createDocument(@PathVariable String name){
        documentService.createDocument(name);
        return "1";
    }
}
