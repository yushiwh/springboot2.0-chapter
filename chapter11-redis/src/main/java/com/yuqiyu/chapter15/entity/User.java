package com.yuqiyu.chapter13.entity;


import com.yuqiyu.chapter13.base.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ys on 2016/9/21
 * <p>
 * ps：最好都使用包装类型，否则用int的话会自动赋值0，会造成查询的错误
 */

@Entity
@Table(name = "user")
public class User extends BaseEntity implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name")
    private String name;


    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private Integer sex;


    @Column(name = "address")
    private String address;


    @Column(name = "username")
    private String username;


    @Column(name = "password")
    private String password;


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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
