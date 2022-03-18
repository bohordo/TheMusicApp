package com.training.TheMusicApp.service.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    UUID id;
    String username;
}
