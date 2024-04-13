package com.micro.loans.mapper;

import com.micro.loans.dto.LoanDto;
import com.micro.loans.entity.Loan;

public class LoanMapper {

    public static LoanDto mapToLoanDto(Loan loan, LoanDto loanDto) {
        loanDto.setLoanNumber(loan.getLoanNumber());
        loanDto.setAmountPaid(loan.getAmountPaid());
        loanDto.setMobileNumber(loan.getMobileNumber());
        loanDto.setLoanType(loan.getLoanType());
        loanDto.setOutstandingAmount(loan.getOutstandingAmount());
        loanDto.setTotalLone(loan.getTotalLone());
        return loanDto;
    }

    public static Loan mapToLoan(LoanDto loanDto, Loan loan) {
        loan.setLoanNumber(loanDto.getLoanNumber());
        loan.setAmountPaid(loanDto.getAmountPaid());
        loan.setMobileNumber(loanDto.getMobileNumber());
        loan.setLoanType(loanDto.getLoanType());
        loan.setOutstandingAmount(loanDto.getOutstandingAmount());
        loan.setTotalLone(loanDto.getTotalLone());
        return loan;
    }
}
