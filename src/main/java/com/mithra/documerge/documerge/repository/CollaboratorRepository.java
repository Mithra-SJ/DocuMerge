package com.mithra.documerge.documerge.repository;

import com.mithra.documerge.documerge.model.Collaborator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CollaboratorRepository extends JpaRepository<Collaborator, Long> {
    //List<Collaborator> findByDocumentId(String documentId);

    Collaborator findByEmailAndDocumentId(String email, Long documentId);

    Collaborator findByDocumentIdAndEmail(Long documentId, String email);

    List<Collaborator> findByDocumentId(Long documentId);
}