package com.micro.accounts.Controller;

import com.micro.accounts.dto.CustomerDetailsDto;
import com.micro.accounts.service.ICustomerService;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CustomerController {
    private final  ICustomerService iCustomerService;

    public CustomerController(ICustomerService iCustomerService) {
        this.iCustomerService = iCustomerService;
    }
@GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto>fetchCustomerDetailsDto(@RequestParam
                                                                     @Pattern(regexp = "(^$|[0-9]{10})",message = "mobile number should be 10 digit")
                                                                     String mobileNumber){
        CustomerDetailsDto customerDetailsDto=iCustomerService.fetchCustomerDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerDetailsDto);
    }


}
