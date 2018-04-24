package com.ys.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.lang.annotation.Annotation;

/**
 * Created by ys on 2016/9/21
 * <p>
 * ps：最好都使用包装类型，否则用int的话会自动赋值0，会造成查询的错误
 */
@ApiModel(description = "用户表")
@Entity
@Table(name = "user")
public class User implements Id, Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(value = "姓名")
    @Column(name = "name")
    private String name;

    @ApiModelProperty(value = "年龄")
    @Column(name = "age")
    private Integer age;

    @ApiModelProperty(value = "性别", allowableValues = "1,2")
    private Integer sex;

    @ApiModelProperty(value = "地址")
    @Column(name = "address")
    private String address;


    @ApiModelProperty(value = "姓名")
    @Column(name = "username")
    private String username;

    @ApiModelProperty(value = "密码")
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

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
