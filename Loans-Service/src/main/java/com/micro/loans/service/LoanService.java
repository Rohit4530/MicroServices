package com.micro.loans.service;

import com.micro.loans.constants.LoansConstant;
import com.micro.loans.dto.LoanDto;
import com.micro.loans.entity.Loan;
import com.micro.loans.exception.LoanAlreadyExistException;
import com.micro.loans.exception.ResourceNotFoundException;
import com.micro.loans.mapper.LoanMapper;
import com.micro.loans.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class LoanService implements ILoanService{

    private  final LoanRepository loneRepository;
     @Autowired
    public LoanService(LoanRepository loneRepository) {
        this.loneRepository = loneRepository;
    }


    @Override
    public void create(String mobileNumber) {
        Optional<Loan>optionalLoan=loneRepository.findByMobileNumber(mobileNumber);
        if(optionalLoan.isPresent()){
            throw  new LoanAlreadyExistException("Loan already taken with mobile number :"+mobileNumber);
        }else{
            loneRepository.save(createNewLoan(mobileNumber));
        }
    }

    @Override
    public LoanDto fetchLoan(String mobileNumber) {
        Loan loan=loneRepository.findByMobileNumber(mobileNumber).orElseThrow(()->new ResourceNotFoundException("Loan is not registered with mobile number: "+mobileNumber));
        return LoanMapper.mapToLoanDto(loan ,new LoanDto());
    }

    @Override
    public boolean update(LoanDto loanDto) {
        Loan loan=loneRepository.findByMobileNumber(loanDto.getMobileNumber()).orElseThrow(
                ()->new ResourceNotFoundException("Loan might not taken with mobile number: "+loanDto.getMobileNumber())
        );
        LoanMapper.mapToLoan(loanDto,loan);
        loneRepository.save(loan);
        return true;
    }

    @Override
    public boolean deleteByMobileNumber(String mobileNumber) {
        Loan loan=loneRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotFoundException("Cannot delete the record with unregistered mobile number: "+mobileNumber)
        );
        loneRepository.deleteById(loan.getId());
        return true;
    }

    private Loan createNewLoan(String mobileNumber) {
        Loan loan=new Loan();
        Long randomLoanNumber=100000000000L+new Random().nextInt(900000000);
        loan.setLoanNumber(randomLoanNumber.toString());
        loan.setMobileNumber(mobileNumber);
        loan.setLoanType("HOME_LONE");
        loan.setTotalLone(LoansConstant.NEW_LOAN_LIMIT);
        loan.setAmountPaid(0);
        loan.setOutstandingAmount(LoansConstant.NEW_LOAN_LIMIT);
        return loan;
    }
}
