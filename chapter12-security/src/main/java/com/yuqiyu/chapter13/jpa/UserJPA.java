package com.yuqiyu.chapter13.jpa;


import com.yuqiyu.chapter13.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/18
 * Time：22:35
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
public interface UserJPA extends JpaRepository<User,Long>
{
    //使用SpringDataJPA方法定义查询
    public User findByUsername(String username);
}
