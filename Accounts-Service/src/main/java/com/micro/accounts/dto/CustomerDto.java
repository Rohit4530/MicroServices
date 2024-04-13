package com.micro.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name="Customer"
)
public class CustomerDto {
    @Schema(
            description ="Name of the customer"
    )
   @Size(min=5,max=30,message = "size of name should be in range of 5 to 3o letters")
    private String name ;
    @Schema(
            description ="Email Id of customer"
    )
    @Email
    private String email;
    @Schema(
            description ="Mobile number of customer"
    )
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be of 10 digit")
    private String mobileNumber;
    private AccountDto accountDto;
}
