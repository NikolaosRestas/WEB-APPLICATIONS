package com.example.demo4.service;

import com.example.demo4.model.County;
import com.example.demo4.repository.CountyRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CountyServiceTest {

    @InjectMocks
    CountyService countyService;

    @Mock
    CountyRepository countyRepository;

    @Test
    void findCountyById() {
        County responseCounty = new County(4L, "ioannina!");
        when(countyRepository.findById(4L)).thenReturn(Optional.of(responseCounty));

        County response = countyService.findCountyById(4L);
        assertThat(response.getId()).isEqualTo(4L);
        assertThat(response.getName()).isEqualTo("ioannina!");
    }

    @Test
    void findCountyById_whenNotExists() {
        when(countyRepository.findById(4L)).thenReturn(Optional.empty());
        Exception exception = assertThrows(RuntimeException.class, () -> countyService.findCountyById(4L));
        assertEquals("Cannot find county with id: 4", exception.getMessage());
    }

    @Test
    void testConcatStrings() {
        String response= countyService.concatStrings("Nikos", 28);
        assertEquals("Nikos's age is 28", response);
    }
}