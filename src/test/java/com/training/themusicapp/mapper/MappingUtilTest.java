package com.training.themusicapp.mapper;

import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MappingUtilTest {

    @Test
    public void mappingUtilTest(){
        MappingUtil mappingUtil = new MappingUtil(new ModelMapper());
        assertNotNull(mappingUtil);
    }
}
