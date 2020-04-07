package com.fersal.jsonpolymorphism.controller;

import com.fersal.jsonpolymorphism.dto.ProgramDetail;
import com.fersal.jsonpolymorphism.service.ProgramDetailService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
     Coded by fernando.salazar on 4/6/20
*/
@RestController
@RequestMapping("/v1")
public class ProgramDetailController {
    private ProgramDetailService programDetailService;

    public ProgramDetailController(ProgramDetailService service) {
        this.programDetailService = service;
    }

    @GetMapping("/programs_detail")
    public List<ProgramDetail> getPrograms() {
        return programDetailService.getPrograms();
    }
}
