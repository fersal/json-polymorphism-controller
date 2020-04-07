package com.fersal.jsonpolymorphism.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
     Coded by fernando.salazar on 4/6/20
*/
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomProgram implements ProgramDetail {
    @Id
    private long id;
    private String programDomain;
    private boolean active;
    private String programOwner;
    private double programCost;

    @Getter
    public static final String TYPE = "custom";
}
