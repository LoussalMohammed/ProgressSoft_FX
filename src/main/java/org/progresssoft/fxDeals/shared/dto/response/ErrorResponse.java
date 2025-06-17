package org.progresssoft.fxDeals.shared.dto.response;

import java.time.LocalDateTime;


public record ErrorResponse(
        int code,
        LocalDateTime timestamp,
        String message,
        String description,
        Object errors
)
{}
