package com.ys.jpa;


import com.ys.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * 创建JPA来操作数据库，继承SpringDataJPA的接口作为父类
 * <p>
 * 继承了JpaRepository接口（SpringDataJPA提供的简单数据操作接口）、
 * JpaSpecificationExecutor（SpringDataJPA提供的复杂查询接口）、
 * Serializable（序列化接口）。
 *
 * @author yushi  2018-04-23
 */
public interface UserJpa extends JpaRepository<User, Long>, JpaSpecificationExecutor<User>, Serializable {


}
