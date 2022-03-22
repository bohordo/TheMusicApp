package com.training.TheMusicApp.repository;

import com.training.TheMusicApp.repository.entity.SongEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@Repository("song")
@RepositoryRestResource(path = "song")
public interface SongRepository extends CrudRepository<SongEntity, String> {}
