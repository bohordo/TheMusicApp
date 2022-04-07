package com.training.themusicapp.controller.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDtoTest {

    @Test
    public void shouldValidateUserDto(){
        UserDto userDto = new UserDto();
        assertNotNull(userDto);
        userDto.setId("id");
        assertEquals("id",userDto.getId());
        userDto.setUsername("name");
        assertEquals("name",userDto.getUsername());
        userDto.setTotalNumberOfLikes(1);
        assertEquals(1,userDto.getTotalNumberOfLikes());
    }
}
