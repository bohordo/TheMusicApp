package com.training.TheMusicApp.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "user_song")
public class UserSongEntity {

    @Id
    private String id;
    private String userId;
    private String songId;
}
