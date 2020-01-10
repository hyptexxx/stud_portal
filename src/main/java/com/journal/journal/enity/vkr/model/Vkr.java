package com.journal.journal.enity.vkr.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="vkr")
public class Vkr {

    @Id
//    @GeneratedValue
    @Column(name = "id_vkr")
    private int id_vkr;

    @Column(name = "date_def")
    private Date date_def;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "id_teacher")
    private int id_teacher;
}
