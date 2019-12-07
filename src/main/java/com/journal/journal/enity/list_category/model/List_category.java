package com.journal.journal.enity.list_category.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;

import javax.persistence.*;

import javax.persistence.GenerationType;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="list_category")
public class List_category {

    @Id
    @Column("id_category")
    @GeneratedValue
    private int id_category;


    @Column("category")
    private String category;
}
