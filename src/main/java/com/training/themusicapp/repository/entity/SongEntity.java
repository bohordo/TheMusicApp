package com.training.themusicapp.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
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
