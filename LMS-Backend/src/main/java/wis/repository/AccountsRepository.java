package wis.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import wis.domain.Accounts;

@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Long> {
	Optional<Accounts> getByUsername(String username);
	Optional<Accounts> getByUsernameAndPassword(String username, String password);

}
