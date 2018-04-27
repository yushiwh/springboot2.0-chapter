package com.jpa.controller;


import com.jpa.domain.primary.User;
import com.jpa.domain.secondary.Test;
import com.jpa.repository.primary.UserRep;
import com.jpa.repository.secondary.TestRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yushi on 2018/4/26.
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private TestRep testRep;

    /**
     * 查询书籍列表
     *
     * @return
     */
    @RequestMapping(value = "/list")
    public List<Test> list() {
        return testRep.findAll();
    }
}
