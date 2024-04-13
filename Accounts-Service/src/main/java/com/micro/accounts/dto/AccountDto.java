package com.micro.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Schema(
        name="Account"
)
public class AccountDto {

    @Schema(
            description ="Account number of customer"
    )
    @Pattern(regexp = "(^$|[0-9]{12})",message = "Account number must be of 12 digit")
    private Long accountNumber;
    @Schema(
            description ="Type of bank account"
    )
    @NotEmpty(message = "Account type cannot be empty")
    private String accountType;
    @Schema(
            description ="Location of the bank"
    )
    @NotEmpty(message = "Branch address cannot be empty")
    private String branchAddress;
}
