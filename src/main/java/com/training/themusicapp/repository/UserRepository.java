package com.training.themusicapp.repository;

import com.training.themusicapp.repository.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("user")
@RepositoryRestResource(path = "user")
public interface UserRepository extends CrudRepository<UserEntity, String> {
    List<UserEntity> findTop3ByOrderByTotalNumberOfLikesDesc();
}
