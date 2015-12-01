package ru.hello.model;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class Person extends PersistentObject {

    @Column(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
