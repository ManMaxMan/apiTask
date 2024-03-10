package org.app.TaskAPI.dao.api.dto.enums;

public enum ERoles {

    USER ("user"),
    ADMIN ("admin");

    private String role;

    ERoles (String role){
        this.role=role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return role;
    }
}
