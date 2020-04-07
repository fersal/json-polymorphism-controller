package com.fersal.jsonpolymorphism.repository;

import com.fersal.jsonpolymorphism.dto.CustomProgram;
import org.springframework.data.jpa.repository.JpaRepository;

/*
     Coded by fernando.salazar on 4/6/20
*/
public interface CustomProgramRepository extends JpaRepository<CustomProgram, Long> {
}
