package com.Sberbank.RostovDitTast.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
@Getter
@Setter
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long barcode;

    @ManyToOne
    @JoinColumn(name="box_id", nullable=true)
    @JsonIgnore
    private Box box;

    public Document(String name,Box box) {
        this.name = name;
        this.box=box;
    }
}
