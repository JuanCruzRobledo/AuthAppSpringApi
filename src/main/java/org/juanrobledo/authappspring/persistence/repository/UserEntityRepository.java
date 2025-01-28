package org.juanrobledo.authappspring.persistence.repository;

import org.juanrobledo.authappspring.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity,Long> {
    Optional<UserEntity> findByUsername(String username); //Se usa un optional para poder lanzar una excepcion si es necesario
}
