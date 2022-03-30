package com.training.themusicapp.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    String id;
    String username;
    private int totalNumberOfLikes;
}
