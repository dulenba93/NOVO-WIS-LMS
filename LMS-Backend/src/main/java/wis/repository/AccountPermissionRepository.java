package wis.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wis.domain.AccountPermission;

@Repository
public interface AccountPermissionRepository extends CrudRepository<AccountPermission, Long>{
	Set<AccountPermission> getByUserId(Long id);
}

