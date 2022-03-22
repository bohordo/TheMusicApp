package com.training.TheMusicApp.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "song")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SongEntity {

    @Id
    private String id;
    private String name;
    private String artists;
    private String genre;
    private int numberOfLikes;

}
