package com.training.themusicapp.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    String id;
    String username;
    private int totalNumberOfLikes;
}
