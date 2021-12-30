package ru.etology.cloudapiback.repository;

import java.util.Map;

public interface RedisRepository {
    Map<Object, Object> findAllMovies();
    void add(Object file);
    void delete(String id);
    Object findFile(String id);
}