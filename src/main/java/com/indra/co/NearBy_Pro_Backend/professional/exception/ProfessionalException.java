package com.indra.co.NearBy_Pro_Backend.professional.exception;

public class ProfessionalException extends RuntimeException {
    private final String errorCode;

    public ProfessionalException(String message) {
        super(message);
        this.errorCode = "PROFESSIONAL_ERROR";
    }

    public ProfessionalException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
} 