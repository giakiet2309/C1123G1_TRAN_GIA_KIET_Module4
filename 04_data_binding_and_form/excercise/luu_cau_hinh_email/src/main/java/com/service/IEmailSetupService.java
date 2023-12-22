package com.service;
import com.model.EmailSetup;

public interface IEmailSetupService {
    EmailSetup show();
    void edit(EmailSetup newEmailSetup);
}
