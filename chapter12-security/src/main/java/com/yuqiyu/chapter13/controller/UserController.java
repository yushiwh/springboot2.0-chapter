package com.yuqiyu.chapter13.controller;

import com.yuqiyu.chapter13.entity.User;
import com.yuqiyu.chapter13.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/14
 * Time：23:32
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@RestController
public class UserController {

    @RequestMapping(value = "/index")
    public String index() {
        return "get index success";
    }
}
