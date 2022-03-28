package com.training.TheMusicApp.repository.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "song")
public class SongEntity {

    @Id
    private String id;
    private String name;
    private String artists;
    private int numberOfLikes;

}
