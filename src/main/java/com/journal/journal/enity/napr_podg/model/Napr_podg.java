package com.journal.journal.enity.napr_podg.model;


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
@Table(name="napr_podg")
public class Napr_podg {

    @Id
    @GeneratedValue
    @Column(name = "id_napr")
    private int id_napr;

    @Column(name = "name")
    private String name;

    @Column(name = "id_kaf")
    private int id_kaf;
}
