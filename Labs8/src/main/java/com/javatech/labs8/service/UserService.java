package com.javatech.labs8.service;

import com.javatech.labs8.repository.UserRepository;
import com.javatech.labs8.stamps.RegistrationStamp;

import javax.inject.Inject;

public class UserService {

    @Inject
    protected UserRepository userRepository;

    @Inject
    protected RegistrationStamp registrationStamp;


}
