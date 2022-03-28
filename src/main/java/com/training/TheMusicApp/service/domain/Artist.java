package com.training.TheMusicApp.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Artist {

    private String name;
    private int totalNumberOfLikes;

}
