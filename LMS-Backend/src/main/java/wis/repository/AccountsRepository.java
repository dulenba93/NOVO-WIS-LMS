package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.Accounts;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

}
