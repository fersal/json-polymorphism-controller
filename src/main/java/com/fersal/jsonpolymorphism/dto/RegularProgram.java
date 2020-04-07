package com.fersal.jsonpolymorphism.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

/*
     Coded by fernando.salazar on 4/6/20
*/
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegularProgram implements ProgramDetail {
    @Id
    private long id;
    private String programDomain;
    private boolean active;
    private LocalDate startDate;

    @Getter
    public static final String TYPE = "regular";
}
