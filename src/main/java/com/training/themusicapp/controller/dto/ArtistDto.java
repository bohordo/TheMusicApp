package com.training.themusicapp.controller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
public class ArtistDto {

    private String name;
    private int totalNumberOfLikes;

}
