package com.example.demo.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String password;

    public UserEntity(){}

    public UserEntity(String name, String password) {
        setName(name);
        setPassword(password);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "name " + getName() + ", password " + getPassword();
    }

}
