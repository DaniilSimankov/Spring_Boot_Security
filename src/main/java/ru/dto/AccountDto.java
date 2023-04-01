package ru.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.models.Account;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    public static AccountDto from(Account account){
        return AccountDto.builder()
                .id(account.getId())
                .firstName(account.getFistName())
                .lastName(account.getLastName())
                .email(account.getEmail())
                .build();
    }

    public static List<AccountDto> from(List<Account> accounts){
        return accounts.stream().map(AccountDto::from).collect(Collectors.toList());

    }

}
