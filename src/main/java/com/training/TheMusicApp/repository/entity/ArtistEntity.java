package com.training.TheMusicApp.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "artist")
public class ArtistEntity {

    @Id
    private String name;
    private int totalNumberOfLikes;
}
