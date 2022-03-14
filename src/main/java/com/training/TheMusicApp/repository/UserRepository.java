package com.training.TheMusicApp.repository;

import com.training.TheMusicApp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository("user")
@RepositoryRestResource(path = "user")
public interface UserRepository extends CrudRepository<User, UUID> {
}
