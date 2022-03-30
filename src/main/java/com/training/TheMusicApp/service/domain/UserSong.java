package com.training.TheMusicApp.service.domain;

import lombok.Builder;

@Builder
public class UserSong {

    private String id;
    private String userId;
    private String songId;

}
