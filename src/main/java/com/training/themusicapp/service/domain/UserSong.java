package com.training.themusicapp.service.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class UserSong {

    private String id;
    private String userId;
    private String songId;

}
