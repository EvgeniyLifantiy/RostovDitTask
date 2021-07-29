package com.Sberbank.RostovDitTast.Entity;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

/**
 * @author Евгений
 * @project RostovDitTast
 */

@Entity
@Table
@NoArgsConstructor
public class Document {
    @Id
    private long id;

    private String name;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long barcode;

    @ManyToOne
    @JoinColumn(name="box_id", nullable=false)
    private Box box;

    public Document(String name) {
        this.name = name;
    }
}
