package wis.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wis.domain.Permission;

@Repository
public interface PermissionRepository extends CrudRepository<Permission, Long>{

}

