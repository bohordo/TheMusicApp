package com.training.TheMusicApp.service.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "song")
@JsonIgnoreProperties (ignoreUnknown = true)
public class Song {

        @Id
        private String id;
        private String name;
        private String artists;
        private String genre;
//        double danceAbility;
//        double energy;
//        double key;
//        double loudness;
//        int mode;
//        double speechiness;
//        double acousticness;
//        double instrumentalness;
//        double liveness;
//        double valence;
//        double tempo;
//        int durationMs;
//        int timeSignature;

}
