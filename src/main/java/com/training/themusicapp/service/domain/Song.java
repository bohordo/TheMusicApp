package com.training.themusicapp.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Song {

        private String id;
        private String name;
        private String artists;
        private int numberOfLikes;
}
