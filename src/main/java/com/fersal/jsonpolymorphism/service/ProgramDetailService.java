package com.fersal.jsonpolymorphism.service;

import com.fersal.jsonpolymorphism.dto.ProgramDetail;
import com.fersal.jsonpolymorphism.repository.CustomProgramRepository;
import com.fersal.jsonpolymorphism.repository.RegularProgramRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
     Coded by fernando.salazar on 4/6/20
*/
@Service
public class ProgramDetailService {
    private CustomProgramRepository customProgramRepository;
    private RegularProgramRepository regularProgramRepository;

    public ProgramDetailService(CustomProgramRepository customProgramRepository,
                                RegularProgramRepository regularProgramRepository) {
        this.regularProgramRepository = regularProgramRepository;
        this.customProgramRepository = customProgramRepository;
    }

    public List<ProgramDetail> getPrograms() {
        return Stream
                .concat(
                        customProgramRepository.findAll().stream(),
                        regularProgramRepository.findAll().stream())
                .collect(Collectors.toList());
    }
}
