package com.mithra.documerge.documerge.controller;

import com.mithra.documerge.documerge.model.Document;
import com.mithra.documerge.documerge.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/create")
    public ResponseEntity<Document> createDocument(@RequestParam String title, @RequestParam String content, @RequestParam String ownerEmail) {
        Document doc = documentService.createDocument(title, content, ownerEmail);
        return ResponseEntity.ok(doc);
    }

    @GetMapping("/my-docs")
    public ResponseEntity<List<Document>> getUserDocuments(@RequestParam String ownerEmail) {
        return ResponseEntity.ok(documentService.getDocumentsByOwner(ownerEmail));
    }
}