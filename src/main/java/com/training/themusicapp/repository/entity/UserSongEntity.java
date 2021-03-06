package com.training.themusicapp.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Table(name = "user_song")
public class UserSongEntity {

    @Id
    private String id;
    private String userId;
    private String songId;
}
