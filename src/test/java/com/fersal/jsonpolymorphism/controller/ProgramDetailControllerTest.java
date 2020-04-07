package com.fersal.jsonpolymorphism.controller;

import com.fersal.jsonpolymorphism.dto.CustomProgram;
import com.fersal.jsonpolymorphism.dto.RegularProgram;
import com.fersal.jsonpolymorphism.repository.CustomProgramRepository;
import com.fersal.jsonpolymorphism.repository.RegularProgramRepository;
import com.fersal.jsonpolymorphism.service.ProgramDetailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ProgramDetailController.class)
public class ProgramDetailControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProgramDetailService programDetailService;
    @MockBean
    private CustomProgramRepository customProgramRepository;
    @MockBean
    private RegularProgramRepository regularProgramRepository;

    @Before
    public void init() {
        ReflectionTestUtils.setField(programDetailService, "customProgramRepository", customProgramRepository);
        ReflectionTestUtils.setField(programDetailService, "regularProgramRepository", regularProgramRepository);

        Mockito.when(programDetailService.getPrograms())
                .thenCallRealMethod();
        Mockito.when(customProgramRepository.findAll())
                .thenReturn(buildCustomProgramMocks());
        Mockito.when(regularProgramRepository.findAll())
                .thenReturn(buildRegularProgramMocks());
    }

    @Test
    public void getPrograms() throws Exception {
        mockMvc.perform(
                get("/v1/programs_detail")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].type").value("custom"))
                .andExpect(jsonPath("$[1].type").value("custom"))
                .andExpect(jsonPath("$[2].type").value("regular"))
        ;
    }

    private List<RegularProgram> buildRegularProgramMocks() {
        return List.of(
                new RegularProgram(222L, "regular1.com", true, LocalDate.now())
        );
    }

    private List<CustomProgram> buildCustomProgramMocks() {
        return List.of(
                new CustomProgram(122L, "custom1.com", true, "Joe", 19.99),
                new CustomProgram(133L, "custom2.com", false, "Sally", 19.99));
    }
}