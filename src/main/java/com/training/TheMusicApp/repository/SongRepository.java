package com.training.TheMusicApp.repository;

import com.training.TheMusicApp.model.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("song")
@RepositoryRestResource(path = "song")
public interface SongRepository extends CrudRepository<Song, UUID> {}
