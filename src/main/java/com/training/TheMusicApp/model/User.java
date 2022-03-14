package com.training.TheMusicApp.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {

    UUID id;
    String username;
}
