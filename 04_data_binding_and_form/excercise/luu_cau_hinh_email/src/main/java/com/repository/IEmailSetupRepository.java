package com.repository;

import com.model.EmailSetup;

public interface IEmailSetupRepository {
    EmailSetup show();
    void edit(EmailSetup newEmailSetup);
}
