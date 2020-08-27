package com.spring.demo.model;

import java.util.Date;
import java.util.Objects;

public class UserDto {

    private String name;
    private String surname;

    private Date addDate;

    public UserDto() {
    }

    public UserDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return name.equals(userDto.name) &&
                surname.equals(userDto.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date date) {
        this.addDate = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
