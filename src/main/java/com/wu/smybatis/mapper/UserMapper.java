package com.wu.smybatis.mapper;

import com.wu.smybatis.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

//表示  mybatis  的mapper  @Repository:  表示dao层  或者@Component
@Mapper
@Repository

public interface UserMapper {
    //
    List<User> findAll();

    //分页查询
    List<User> findAllPages(Map pages);


    User findUserById(int userId);

    void addUser(User user);

    void deleteUser(String id);

    void updateUser(User user);

}
