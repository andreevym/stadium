package ru.hello.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "employee")
public class Employee extends Person {

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Address address;

    @Column(name = "salary")
    private BigDecimal salary;

    public Employee() {

    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
}
