package ru.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dto.AccountDto;
import ru.models.Account;
import ru.repositories.AccountsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    private final AccountsRepository accountsRepository;

    @Override
    public List<AccountDto> getAllAccounts() {
        return AccountDto.from(accountsRepository.findAllByState(Account.State.CONFIRMED));
    }

    @Override
    public void deleteAccount(Long accountId) {
        Account account = accountsRepository.getById(accountId);
        account.setState(Account.State.DELETED);
        accountsRepository.save(account);
    }
}
