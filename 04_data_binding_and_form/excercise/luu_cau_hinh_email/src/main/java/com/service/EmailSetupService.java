package com.service;

import com.model.EmailSetup;
import com.repository.IEmailSetupRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class EmailSetupService implements IEmailSetupService {
    @Autowired
    private IEmailSetupRepository repository;
    @Override
    public EmailSetup show(){
        return repository.show();
    }
    @Override
    public void edit(EmailSetup newEmailSetup) {
        repository.edit(newEmailSetup);
    }
}
