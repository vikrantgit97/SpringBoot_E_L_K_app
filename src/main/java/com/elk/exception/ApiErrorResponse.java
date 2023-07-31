package com.elk.exception;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
/**
 * @author Vikrant_Gopewar on 31-07-2023
 * @Project SpringBoot_E_L_K
 */


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorResponse {
    private boolean status;
    private String message;
    private String error;
    private int errorNumber;
    private LocalDateTime timestamp;
}
