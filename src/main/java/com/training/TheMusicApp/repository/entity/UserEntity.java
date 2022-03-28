package com.training.TheMusicApp.repository.entity;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;


@Data
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    String id;
    String username;
    private int totalNumberOfLikes;
}
