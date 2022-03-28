package com.training.TheMusicApp.repository;

import com.training.TheMusicApp.repository.entity.ArtistEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository("artist")
@RepositoryRestResource(path = "artist")
public interface ArtistRepository extends CrudRepository<ArtistEntity, String> {

    List<ArtistEntity> findTop3ByOrderByTotalNumberOfLikesDesc();
    List<ArtistEntity> findTop5ByOrderByTotalNumberOfLikesDesc();

}
