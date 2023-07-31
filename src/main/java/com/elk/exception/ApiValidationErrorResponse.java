package com.elk.exception;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @author Vikrant_Gopewar on 31-07-2023
 * @Project SpringBoot_E_L_K
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiValidationErrorResponse {
    private boolean status;
    private String message;
    private String error;
    private Map<String, List<String>> errors;
    private int errorNumber;
    private LocalDateTime timestamp;
}