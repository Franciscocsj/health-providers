package br.com.healthProviders.exception;

public class HealthProvidersNotFoundException extends RuntimeException {

    public HealthProvidersNotFoundException(String msg) {
        super(msg);
    }
}
