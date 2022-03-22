package com.training.TheMusicApp.repository.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "artist")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistEntity {

    @Id
    private UUID id;
    private String name;
}
