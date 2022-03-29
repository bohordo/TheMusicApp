package com.training.TheMusicApp.service.domain;

import lombok.Builder;
import lombok.Data;

//@Data
@Builder
public class UserSong {

    private String id;
    private String userId;
    private String songId;

}
