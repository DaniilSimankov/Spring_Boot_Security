package ru.services;

import ru.dto.AccountDto;

import java.util.List;

public interface AccountsService {
    List<AccountDto> getAllAccounts();

    void deleteAccount(Long accountId);
}
