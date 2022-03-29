package com.training.TheMusicApp.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    String id;
    String username;
    private int totalNumberOfLikes;
}
