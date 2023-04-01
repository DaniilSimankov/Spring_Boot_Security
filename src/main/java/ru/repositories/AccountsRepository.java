package ru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.models.Account;

import java.util.List;
import java.util.Optional;

public interface AccountsRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByEmail(String email);
    List<Account> findAllByState(Account.State state);
}
