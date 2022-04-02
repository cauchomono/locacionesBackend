package com.forero.locaciones.service;

import com.forero.locaciones.model.Locacion;
import com.forero.locaciones.repository.LocacionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class LocacionServiceTest {

    @Mock
    LocacionRepository locacionRepository;

    @InjectMocks
    LocacionService locacionService;

    Locacion locacion1;
    Locacion locacion2;
    List<Locacion> locaciones;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Locacion locacion1 = new Locacion();
        locacion1.name="Parque";
        locacion1.area_m2=20;
        locacion1.setParentLocation(null);

        Locacion locacion2 = new Locacion();
        locacion2.name="Baño";
        locacion2.area_m2=5;
        locacion2.setParentLocation(locacion1);

        locaciones = new ArrayList<>();
        locaciones.add(locacion1);
        locaciones.add(locacion2);


    }
    @Test
    void findAll() {
        when(locacionRepository.findAll()).thenReturn(locaciones);
        assertNotNull(locacionService.findAll());
    }

    @Test
    void save() {
        when(locacionRepository.save(any(Locacion.class))).thenReturn(new Locacion());
        assertNotNull(locacionService.save(new Locacion()));

    }
}