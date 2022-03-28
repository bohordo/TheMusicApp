package com.training.TheMusicApp.repository.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@Entity
@Table(name = "artist")
public class ArtistEntity {

    @Id
    private String name;
    private int totalNumberOfLikes;
}
