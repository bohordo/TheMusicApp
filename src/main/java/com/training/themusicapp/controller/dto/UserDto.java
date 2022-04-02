package com.training.themusicapp.controller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    String id;
    String username;
    private int totalNumberOfLikes;
}
