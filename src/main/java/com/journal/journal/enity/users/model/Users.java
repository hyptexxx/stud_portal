package com.journal.journal.enity.users.model;


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
@Table(name="users")
public class Users {

    @Id
//    @GeneratedValue
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "fio")
    private String fio;

    @Column(name = "id_napr")
    private int id_napr;

    @Column(name = "id_category")
    private int id_category;
}
