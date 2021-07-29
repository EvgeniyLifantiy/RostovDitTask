package com.Sberbank.RostovDitTast.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author Евгений
 * @project RostovDitTast
 */
@Entity
@Table
public class Box {

    @Id
    private long box_id;

    private String name;

    private long barcode;

    @OneToMany(mappedBy = "box")
    private Set<Document> documents;

}
