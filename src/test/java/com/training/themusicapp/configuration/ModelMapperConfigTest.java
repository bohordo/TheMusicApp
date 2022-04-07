package com.training.themusicapp.configuration;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ModelMapperConfigTest {

    @Test
    public void modelMapperConfigTest(){
        ModelMapperConfig modelMapperConfig = new ModelMapperConfig();
        assertNotNull(modelMapperConfig);
        assertNotNull(modelMapperConfig.mapper());
    }
}
