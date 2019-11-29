package com.icefrog.loadbalance.provider;

public class ProviderException extends RuntimeException {

    public ProviderException(String message) {
        super(message);
    }

    public ProviderException(Throwable cause) {
        super(cause);
    }

    public ProviderException(String message, Throwable cause) {
        super(message, cause);
    }
}
