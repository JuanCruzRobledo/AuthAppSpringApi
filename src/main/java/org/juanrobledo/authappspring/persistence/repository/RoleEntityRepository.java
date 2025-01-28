package org.juanrobledo.authappspring.persistence.repository;

import org.juanrobledo.authappspring.persistence.entity.RoleEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleEntityRepository extends CrudRepository<RoleEntity,Long> {
}
