package com.journal.journal.enity.teacher.model;

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
@Table(name="teachers")
public class Teacher {

    @Id
//    @GeneratedValue
    @Column(name = "id_teacher")
    private int id_teacher;

    @Column(name = "id_n")
    private int id_n;

    @Column(name = "fio")
    private String fio;
}
