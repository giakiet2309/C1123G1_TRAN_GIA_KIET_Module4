package com.repository;

import com.model.EmailSetup;

@org.springframework.stereotype.Repository
public class EmailSetupRepository implements IEmailSetupRepository {
    private EmailSetup emailSetup = new EmailSetup("Vietnamese",25,true,"chữ ký");
    @Override
    public EmailSetup show(){
        return emailSetup;
    }
    @Override
    public void edit(EmailSetup newEmailSetup){
        emailSetup = newEmailSetup;
    }
}
