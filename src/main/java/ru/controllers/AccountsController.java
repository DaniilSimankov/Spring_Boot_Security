package ru.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.services.AccountsService;

@Controller
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountsController {

    private final AccountsService accountsService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String getAccountsPage(Model model){
        model.addAttribute("accounts", accountsService.getAllAccounts());
        return "accounts";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/{account-id}/delete")
    public String deleteAccount(@PathVariable("account-id") Long accountId){
        accountsService.deleteAccount(accountId);
        return "redirect:/accounts";
    }
}
