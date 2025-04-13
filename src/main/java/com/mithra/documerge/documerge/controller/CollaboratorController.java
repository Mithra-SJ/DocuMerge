package com.mithra.documerge.documerge.controller;

import com.mithra.documerge.documerge.model.Collaborator;
import com.mithra.documerge.documerge.service.CollaboratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/collaborators")
public class CollaboratorController {
    @Autowired
    private CollaboratorService collaboratorService;
    
    @PostMapping("/add")
    public ResponseEntity<Collaborator> addCollaborator(@PathVariable Long documentId, @RequestParam String email, @RequestParam String accessLevel) {
        return ResponseEntity.ok(collaboratorService.addCollaborator(documentId, email, accessLevel));
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<Collaborator>> getCollaborators(@PathVariable Long documentId) {
        return ResponseEntity.ok(collaboratorService.getCollaborators(documentId));
    }
    
    @DeleteMapping("/remove")
    public ResponseEntity<String> removeCollaborator(@PathVariable Long documentId, @RequestParam String email) {
        collaboratorService.removeCollaborator(documentId, email);
        return ResponseEntity.ok("Collaborator removed successfully");
    }
}