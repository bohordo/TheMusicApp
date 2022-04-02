package com.training.themusicapp.controller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class SongDto {

    private String id;
    private String name;
    private String artists;
    private int numberOfLikes;

}
