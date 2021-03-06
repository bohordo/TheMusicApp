package com.training.themusicapp.repository;

import com.training.themusicapp.repository.entity.UserSongEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository("user_song")
@RepositoryRestResource(path = "user_song")
public interface UserSongRepository extends CrudRepository<UserSongEntity,String> {}
