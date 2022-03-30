package com.training.themusicapp.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "song")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SongEntity {

    @Id
    private String id;
    private String name;
    private String artists;
    private int numberOfLikes;

}
