package com.greve.cavera_control.auth.model.enums;

public enum UserRoleEnum {

    ADMIN("admin"),
    DEV("dev"),
    USER("user");

    private String role;

    UserRoleEnum(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

}
