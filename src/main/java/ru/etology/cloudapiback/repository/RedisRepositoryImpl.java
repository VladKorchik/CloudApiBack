package ru.etology.cloudapiback.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Map;

@Repository
public class RedisRepositoryImpl implements RedisRepository {
    private static final String KEY = "File";
    private RedisTemplate<String, Object> redisTemplate;
    private HashOperations hashOperations;
    @Autowired
    public RedisRepositoryImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }
    @PostConstruct
    private void init(){
        hashOperations = redisTemplate.opsForHash();
    }
    public void add(final Object file) {
        hashOperations.put(KEY, file.getId(), file.getName());
    }
    public void delete(final String id) {
        hashOperations.delete(KEY, id);
    }
    public Object findMovie(final String id){
        return (Object) hashOperations.get(KEY, id);
    }
    public Map<Object, Object> findAllMovies(){
        return hashOperations.entries(KEY);
    }
}