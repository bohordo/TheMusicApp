package com.training.TheMusicApp.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "song")
public class SongEntity {

    @Id
    private String id;
    private String name;
    private String artists;
    private int numberOfLikes;

}
