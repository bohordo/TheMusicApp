package com.training.TheMusicApp.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;


@Data
@Entity
@Table(name = "user")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserEntity {

    @Id
    UUID id;
    String username;
}
