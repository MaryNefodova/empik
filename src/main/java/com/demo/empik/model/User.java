package com.demo.empik.model;

public class User {
    private Long id;

    private String login;

    private String name;

    private String type;

    private String avatarUrl;

    private String createdAt;

    private Integer calculations;

    public User(Long id, String login, String name, String type, String avatarUrl, String createdAt, Integer calculations) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.type = type;
        this.avatarUrl = avatarUrl;
        this.createdAt = createdAt;
        this.calculations = calculations;
    }

    public String getLogin() {
        return login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getCalculations() {
        return calculations;
    }

    public void setCalculations(Integer calculations) {
        this.calculations = calculations;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
