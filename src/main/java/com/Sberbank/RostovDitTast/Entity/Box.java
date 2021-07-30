package com.Sberbank.RostovDitTast.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Евгений
 * @project RostovDitTast
 */
@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Box {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long box_id;

    private String name;

    @GeneratedValue(strategy = GenerationType.AUTO)
    private long barcode;

    @OneToMany(mappedBy = "box", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents=new ArrayList<>();

    public Box(String name) {
        this.name = name;
    }
}
