package com.training.TheMusicApp.repository;

import com.training.TheMusicApp.repository.entity.ArtistEntity;
import com.training.TheMusicApp.repository.entity.SongEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("song")
@RepositoryRestResource(path = "song")
public interface SongRepository extends CrudRepository<SongEntity, String> {

    List<SongEntity> findTop5ByOrderByNumberOfLikesDesc();
    List<SongEntity> findTop10ByOrderByNumberOfLikesDesc();
    List<SongEntity> findTop15ByOrderByNumberOfLikesDesc();
}
