package com.wu.smybatis.controller;

import com.wu.smybatis.mapper.UserMapper;
import com.wu.smybatis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper mapper;

    @GetMapping("/findAll")
    public List<User> findAll() {
        List<User> lists = mapper.findAll();
        return lists;
    }

    //分页查询
    @GetMapping("/findAllPages")
    public List<User> findAllPages(@RequestParam("pageNum") int pageNum) {
        int pageSize = 2;
        Map<String, Object> data = new HashMap<>();
        data.put("start", (pageSize - 1) * pageNum);
        data.put("pageSize", pageSize);
        List<User> lists = mapper.findAllPages(data);
        return lists;
    }

    /**
     * 分页查询
     *
     * @param pageNum  页数
     * @param pageSize 每页展示的数量
     * @return
     */
    @GetMapping("/findAllPages2")
    public List<User> findAllPages(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize) {

        Map<String, Object> datas = new HashMap<>();
        datas.put("start", (pageNum - 1) * pageNum);
        datas.put("pageSize", pageSize);
        List<User> lists = mapper.findAllPages(datas);
        return lists;
    }

    /**
     * 添加用户
     *
     * @param user
     */
    @GetMapping("/addUser")
    public void addUser(User user) {
        mapper.addUser(user);
    }

    /**
     * 更新用户
     *
     * @param user
     */
    @GetMapping("/updateUser")
    public void updateUser(User user) {
        mapper.updateUser(user);
    }

    /**
     * 指定id删除用户
     *
     * @param id
     */
    @GetMapping("/deleteUser")
    public void deleteUser(@RequestParam("id") String id) {
        mapper.deleteUser(id);
    }


}
