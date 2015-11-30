package ru.hello.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

public interface ObjectWithId<T> {
    T getId();
}
