/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: UserController
 * Author:   yushi
 * Date:     2018/4/23 14:23
 * Description: 用户Controller
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jztey.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.jztey.demo.domain.User;
import com.jztey.demo.jpa.UserJpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈用户Controller〉
 * 直接使用JPA的接口操作数据库
 *
 * @author yushi
 * @create 2018/4/23
 * @since 1.0.0
 */
@RestController
@RequestMapping(value = "/index")
public class UserController {

    @Autowired
    private UserJpa userJpa;

    /**
     * 查询用户列表的方法
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list() {
        return userJpa.findAll();
    }

    /**
     * 保存添加用户的方法
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public User save(User user) {
        return userJpa.save(user);
    }


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public List<User> delete(Long id) {
        User user = new User();
        user.setId(id);
        userJpa.delete(user);
        return userJpa.findAll();
    }





}