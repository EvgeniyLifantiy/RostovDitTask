package com.Sberbank.RostovDitTast.Repository;

import com.Sberbank.RostovDitTast.Entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Евгений
 * @project RostovDitTast
 */
public interface DocumentRepository extends JpaRepository<Document,Long> {
}
