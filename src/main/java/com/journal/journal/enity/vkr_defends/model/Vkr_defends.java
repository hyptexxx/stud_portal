package com.journal.journal.enity.vkr_defends.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class Vkr_defends {

    @Getter
    @Setter
    private Date date_def;

    @Getter
    @Setter
    private String user_name;

    @Getter
    @Setter
    private String name_teacher;
}
