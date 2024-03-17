package com.github.ManMaxMan.TasAPI.core.dto;


import com.github.ManMaxMan.TasAPI.core.enums.ERoles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class UserDTO {

    private String login;
    private String password;
    private String FIO;
    private LocalDate birthday;
    private LocalDateTime registrationDate;
    private ERoles role;

    public UserDTO(){
    }

    public UserDTO(String login, String password, String fio, LocalDate birthday, LocalDateTime registrationDate, ERoles role) {
        this.login = login;
        this.password = password;
        this.FIO = fio;
        this.birthday = birthday;
        this.registrationDate = registrationDate;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public ERoles getRole() {
        return role;
    }

    public void setRole(ERoles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", FIO='" + FIO + '\'' +
                ", birthday=" + birthday +
                ", registrationDate=" + registrationDate +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO user = (UserDTO) o;
        return login.equals(user.login) && password.equals(user.password) && FIO.equals(user.FIO) && birthday.equals(user.birthday) && registrationDate.equals(user.registrationDate) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, FIO, birthday, registrationDate, role);
    }
}
