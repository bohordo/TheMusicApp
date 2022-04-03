package com.training.themusicapp.controller.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSongDto {

    private String userId;
    private String songId;
}
