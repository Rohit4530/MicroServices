package com.micro.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Schema(
        name = "Card"
)
public class CardDto {
    @Schema(
            description ="Mobile number of customer"
    )
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Account number must be of 10 digit")
    private String mobileNumber;
    @Schema(
            description ="Card number of customer"
    )
    @NotEmpty
    @Pattern(regexp = "(^$|[0-9]{12})",message = "Mobile number must be of 12 digit")
    private String cardNumber;
    @Schema(
            description = "Type of Card"
    )
    @NotEmpty(message = "card type cannot be empty")
    private  String cardType;
    @Schema(
            description = "Total limit on the Card"
    )
    @Positive(message = "total limit should be greater than zero")
    private long totalLimit;
    @Positive(message = "total limit should be greater than zero")
    @Schema(
            description = "Amount used from card"
    )
    private long amountUsed;
    @Positive(message = "total limit should be greater than zero")
    private long availableAmount;
}
