package com.journal.journal.enity.list_kafedr.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="list_kafedr")
public class List_kafedr {

    @Id
//    @GeneratedValue
    @Column(name="id_kafedr")
    private int id_kafedr;

    @Column(name="name")
    private String name;
}
