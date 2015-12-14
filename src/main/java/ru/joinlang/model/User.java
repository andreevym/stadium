package ru.joinlang.model;

public class User {

    private String id;
    private String fullName;
    private String lastName;
    private String description;
    private String email;
    private String memberOf;

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMemberOf(String memberOf) {
        this.memberOf = memberOf;
    }

    public String getMemberOf() {
        return memberOf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
