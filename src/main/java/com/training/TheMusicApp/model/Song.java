package com.training.TheMusicApp.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "song")
public class Song {

        @Id
        private UUID id;
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
