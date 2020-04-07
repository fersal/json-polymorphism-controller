package com.fersal.jsonpolymorphism.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/*
     Coded by fernando.salazar on 4/6/20
*/
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = RegularProgram.class, name = "regular"),
        @JsonSubTypes.Type(value = CustomProgram.class, name = "custom")
})
public interface ProgramDetail {
    long getId();

    void setId(long id);

    String getProgramDomain();

    void setProgramDomain(String programDomain);

    void setActive(boolean isActive);

    boolean isActive();
}
