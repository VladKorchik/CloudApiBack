package ru.etology.cloudapiback.config;

public interface MessagePublisher {
    void publish(final String message);
}