package com.mithra.documerge.documerge.model;

import jakarta.persistence.*;

@Entity
@Table(name = "collaborators")
public class Collaborator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private Long documentId;
    private String role;

    public Collaborator() {}

    public Collaborator(String email, Long documentId, String role) {
        this.email = email;
        this.documentId = documentId;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Long getDocumentId() {
        return documentId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDocument(Document document) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDocument'");
    }

    public void setEmail(String email2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setEmail'");
    }

    public void setAccessLevel(String accessLevel) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAccessLevel'");
    }
}