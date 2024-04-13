package com.micro.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "Loans"
)
public class LoanDto {
    @Schema(
            description = "Mobile number of user"
    )
    @NotEmpty(message = "Mobile number cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number should be of 10 digit")
    private String mobileNumber;
    @Schema(
            description = "Loan number of user"
    )
    @NotEmpty(message = "Loan number cannot be empty")
    @Pattern(regexp = "(^$|[0-9]{12})",message = "Mobile number should be of 12 digit")
    private String loanNumber;

    @Schema(
            description = "Type of the loan"
    )
    @NotEmpty(message = "Loan type cannot be empty")
    private String loanType;
    @Positive(message = "total lone should be positive")
    @Schema(
            description = "Total amount of loan taken"
    )
    private int totalLone;
    @PositiveOrZero
    @Schema(
            description = "Total amount of loan paid"
    )
    private int amountPaid;
    @PositiveOrZero
    private int outstandingAmount;
}
