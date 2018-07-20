package com.example.demo.domain.mapper;

import com.example.demo.domain.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserEntity> getAll();

    UserEntity getOne(String name);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(String name);
}
