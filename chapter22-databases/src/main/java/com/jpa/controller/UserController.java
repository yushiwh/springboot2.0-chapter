package com.jpa.controller;


import com.jpa.domain.primary.User;
import com.jpa.repository.primary.UserRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yushi on 2018/4/26.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserRep userRep;

    /**
     * 查询书籍列表
     *
     * @return
     */
    @RequestMapping(value = "/list")
    public List<User> list() {
        return userRep.findAll();
    }
}
