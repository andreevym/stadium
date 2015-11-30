package ru.hello.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
public class Person extends ObjectWithIncrementId {

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated")
    private Date updated;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getUpdated() {
        return new Date(updated.getTime());
    }

    public void setUpdated(Date updated) {
        this.updated = new Date(updated.getTime());
    }
}
