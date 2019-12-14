package com.journal.journal.enity.science_publication_filter.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor

public class Science_publication_filter {
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String text;

    @Getter
    @Setter
    private String fio;
}
