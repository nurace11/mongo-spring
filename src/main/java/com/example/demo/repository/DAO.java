package com.example.demo.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DAO<T, ID> {
    Optional<T> findById(ID id);
//    Collection<T> findAll();
    List<T> findAll();

    int save(T t);

    void update(T t);
    void updateById(ID id);

    void delete(T t);
    void deleteById(ID id);
}
