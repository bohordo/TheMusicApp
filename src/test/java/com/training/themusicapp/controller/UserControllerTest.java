package com.training.themusicapp.controller;

import com.training.themusicapp.controller.dto.UserDto;
import com.training.themusicapp.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUsers () throws Exception {

        List<UserDto> listSongDto = new ArrayList<>();
        UserDto userDto = new UserDto();
        listSongDto.add(userDto);

        Mockito.when(userService.getUsers("1")).thenReturn(listSongDto);

        mockMvc.perform(get("/user/top/1"))
                .andExpect(status().isOk());
    }
}
