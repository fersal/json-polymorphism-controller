package com.fersal.jsonpolymorphism.repository;

import com.fersal.jsonpolymorphism.dto.RegularProgram;
import org.springframework.data.jpa.repository.JpaRepository;

/*
     Coded by fernando.salazar on 4/6/20
*/
public interface RegularProgramRepository extends JpaRepository<RegularProgram, Long> {
}
