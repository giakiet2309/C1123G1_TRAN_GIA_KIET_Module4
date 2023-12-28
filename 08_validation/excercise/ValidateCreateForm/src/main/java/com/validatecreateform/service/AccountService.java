package com.validatecreateform.service;

import com.validatecreateform.model.Account;
import com.validatecreateform.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
    @Override
    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public List<Account> showAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(int id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public void updateAccount(Account account) {
        if (accountRepository.findById(account.getId()) != null){
            accountRepository.save(account);
        }
    }

    @Override
    public void deleteAccountById(int id) {
        if (accountRepository.findById(id) != null){
            accountRepository.deleteById(id);
        }
    }
}
