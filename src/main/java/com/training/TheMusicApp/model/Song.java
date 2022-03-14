package com.training.TheMusicApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "song")
public class Song {

        @Id
        UUID id;
        String name;
        String artists;
        String genre;
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
