package com.training.themusicapp.service.domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    @Test
    public void shouldValidateUser(){
        User user = new User();
        assertNotNull(user);
        user.setId("id");
        user.setUsername("name");
        user.setTotalNumberOfLikes(1);
        assertEquals("id",user.getId());
        assertEquals("name",user.getUsername());
        assertEquals(1,user.getTotalNumberOfLikes());
    }
}
