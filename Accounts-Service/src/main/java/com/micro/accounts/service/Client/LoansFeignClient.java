package com.micro.accounts.service.Client;

import com.micro.accounts.dto.CardDto;
import com.micro.accounts.dto.LoanDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("loans")
public interface LoansFeignClient {
    @GetMapping("/api/fetch")
    public ResponseEntity<LoanDto>fetchLoan(
            @RequestParam
            String mobileNumber
    );
}
