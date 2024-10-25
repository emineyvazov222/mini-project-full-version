package org.spring.FullVersion;

public class FamilyOverflowException extends RuntimeException {
    public FamilyOverflowException(String message, Exception e) {
        super(message);
    }
}
