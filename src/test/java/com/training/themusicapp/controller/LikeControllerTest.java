package com.training.themusicapp.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

class LikeControllerTest {

    @Autowired
    LikeController likeController;

    private MockMvc mockMvc;

    //@Test
    void likeASongShouldResponseOk(){
        likeController.likeASong("","");
    }

    //@Test
    void likeASongShouldResponseAccepted(){
        likeController.likeASong("","");
    }

}
