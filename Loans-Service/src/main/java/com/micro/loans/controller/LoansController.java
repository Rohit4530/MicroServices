package com.micro.loans.controller;

import com.micro.loans.constants.LoansConstant;
import com.micro.loans.dto.LoanDto;
import com.micro.loans.dto.LoansContactInfoDto;
import com.micro.loans.dto.ResponseDto;
import com.micro.loans.service.ILoanService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoansController {

   private final  ILoanService iloanService;
   @Autowired
   private LoansContactInfoDto loansContactInfoDto;
    @Autowired
    public LoansController(ILoanService iloanService) {
        this.iloanService = iloanService;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto>createLoans(@RequestParam
        @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be of 10 digit")
                String mobileNumber){
        iloanService.create(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(
                        LoansConstant.STATUS_201,
                        LoansConstant.MESSAGE_201
                ));
    }
    @GetMapping("/fetch")
    public ResponseEntity<LoanDto>fetchLoan(
            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be of 10 digit")
            String mobileNumber
            ){
        LoanDto loanDto=iloanService.fetchLoan(mobileNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loanDto);
    }
    @PutMapping("/update")
    public ResponseEntity<ResponseDto>updateLoanDetails(@Valid @RequestBody LoanDto loanDto){
      boolean isUpdated=iloanService.update(loanDto);
      if(isUpdated){
          return  ResponseEntity
                  .status(HttpStatus.OK)
                  .body(new ResponseDto(
                          LoansConstant.STATUS_200,
                          LoansConstant.MESSAGE_200
                  ));
      }else{
          return ResponseEntity
                  .status(HttpStatus.BAD_REQUEST)
                  .body(new ResponseDto(
                          LoansConstant.STATUS_400,
                          LoansConstant.MESSAGE_400
                  ));
      }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto>deleteLoanDetails(
            @RequestParam
            @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be of 10 digit")
            String mobileNumber){
        boolean isDeleted=iloanService.deleteByMobileNumber(mobileNumber);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(
                            LoansConstant.STATUS_200,
                            LoansConstant.MESSAGE_200
                    ));
        }else{
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto(
                            LoansConstant.STATUS_400,
                            LoansConstant.MESSAGE_400
                    ));
        }
    }
    @GetMapping("/contact-info")
    public ResponseEntity<LoansContactInfoDto>getContactDetails(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(loansContactInfoDto);
    }


}
