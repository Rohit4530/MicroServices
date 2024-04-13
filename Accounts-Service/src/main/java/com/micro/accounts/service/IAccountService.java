package com.micro.accounts.service;

import com.micro.accounts.dto.CustomerDto;
import org.springframework.stereotype.Service;

@Service
public interface IAccountService {
    public  void createAccount(CustomerDto customerDto);

    CustomerDto fetchAccount(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);

    boolean deleteAccount(String mobileNumber);
}
