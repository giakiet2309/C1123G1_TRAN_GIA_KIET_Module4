package com.validatecreateform.service;

import com.validatecreateform.model.Account;

import java.util.List;

public interface IAccountService {
    void createAccount(Account account);
    List<Account> showAccount();
    Account getAccountById(int id);
    void updateAccount(Account account);
    void deleteAccountById(int id);
}
