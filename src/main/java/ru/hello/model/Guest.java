package ru.hello.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "guest")
public class Guest extends Person {

    private Integer placeNumber;

    public Guest() {

    }

    public Integer getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(Integer placeNumber) {
        this.placeNumber = placeNumber;
    }
}
