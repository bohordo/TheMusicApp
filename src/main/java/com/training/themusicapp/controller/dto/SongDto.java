package com.training.themusicapp.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {

    private String id;
    private String name;
    private String artists;
    private int numberOfLikes;

}
