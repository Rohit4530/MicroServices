package com.micro.accounts.service;

import com.micro.accounts.dto.*;
import com.micro.accounts.entity.Accounts;
import com.micro.accounts.entity.Customer;
import com.micro.accounts.exceptions.ResourceNotFoundException;
import com.micro.accounts.mapper.AccountMapper;
import com.micro.accounts.mapper.CustomerMapper;
import com.micro.accounts.repository.AccountsRepository;
import com.micro.accounts.repository.CustomerRepository;
import com.micro.accounts.service.Client.CardsFeignClient;
import com.micro.accounts.service.Client.LoansFeignClient;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements ICustomerService{
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer= customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(
                        ()->new ResourceNotFoundException("Customer","MobileNumber",mobileNumber));
        Accounts accounts= accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(
                        ()->new ResourceNotFoundException("Customer","MobileNumber",mobileNumber));
        CustomerDetailsDto customerDetailsDto=CustomerMapper.mapToCustomerDetailsDto(customer,new CustomerDetailsDto());
        customerDetailsDto.setAccountDto(AccountMapper.mapToAccountDto(accounts,new AccountDto()));
        ResponseEntity<LoanDto>loanDtoResponseEntity=loansFeignClient.fetchLoan(mobileNumber);
        customerDetailsDto.setLoanDto(loanDtoResponseEntity.getBody());
        ResponseEntity<CardDto>cardsDtoResponseEntity=cardsFeignClient.fetchCard(mobileNumber);
        customerDetailsDto.setCardDto(cardsDtoResponseEntity.getBody());
        return  customerDetailsDto;
    }
}
