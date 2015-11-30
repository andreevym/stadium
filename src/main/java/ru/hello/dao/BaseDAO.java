package ru.hello.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T, PK  extends Serializable> {

    // C R U D

    T create(T t);
    T read(PK id);
    T update(T t);
    void delete(T t);
    void delete(PK id);

    // other
    <T> T find(PK id);

    List<T> findAll();

    List<T> distinctFindAll();

    <T> T save(T entity);
}
