package com.training.themusicapp.repository;

import com.training.themusicapp.repository.entity.ArtistEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("artist")
@RepositoryRestResource(path = "artist")
public interface ArtistRepository extends CrudRepository<ArtistEntity, String> {

    List<ArtistEntity> findTop3ByOrderByTotalNumberOfLikesDesc();
    List<ArtistEntity> findTop5ByOrderByTotalNumberOfLikesDesc();
    ArtistEntity findByName(String name);

}
