package com.micro.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name="ApiResponse"
)
public class ResponseDto {
    @Schema(
            description = "status code of response"
    )
    private String statusCode;
    @Schema(
            description = "status code of request"
    )
    private String statusMessage;
}
