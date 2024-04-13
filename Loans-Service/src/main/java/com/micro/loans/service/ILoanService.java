package com.micro.loans.service;

import com.micro.loans.dto.LoanDto;
import org.springframework.stereotype.Service;

@Service
public interface ILoanService {
    void create(String mobileNumber);

    LoanDto fetchLoan(String mobileNumber);

    boolean update(LoanDto loanDto);

    boolean deleteByMobileNumber(String mobileNumber);
}
