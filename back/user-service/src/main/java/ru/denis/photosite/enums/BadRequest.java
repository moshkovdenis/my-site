package ru.denis.photosite.enums;

public enum BadRequest {
    CREATE_USER("User exist");

    String content;

    BadRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
