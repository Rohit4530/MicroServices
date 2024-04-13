package com.micro.accounts.service.Client;

import com.micro.accounts.dto.CardDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cards")
public interface CardsFeignClient {
    @GetMapping(value = "/api/fetch",consumes = "application/json")
    public ResponseEntity<CardDto> fetchCard(@Valid
                                             @RequestParam
                                             String mobileNumber);
}
