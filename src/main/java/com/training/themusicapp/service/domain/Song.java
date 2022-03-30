package com.training.themusicapp.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Song {

        private String id;
        private String name;
        private String artists;
        private int numberOfLikes;
        private List<String> usersThatLikedThisSong;
}
