package org.app.TaskAPI.dao.api.dto;

import org.app.TaskAPI.dao.api.dto.enums.ERoles;
import java.util.Objects;

public class User {

    private String login;
    private String password;
    private String FIO;
    private String birthday;
    private String registrationDate;
    private ERoles role;

    public User (){
    }

    public User(String login, String password, String fio, String birthday, String registrationDate, ERoles role) {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
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
        return "User{" +
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
        User user = (User) o;
        return login.equals(user.login) && password.equals(user.password) && FIO.equals(user.FIO) && birthday.equals(user.birthday) && registrationDate.equals(user.registrationDate) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, FIO, birthday, registrationDate, role);
    }
}
