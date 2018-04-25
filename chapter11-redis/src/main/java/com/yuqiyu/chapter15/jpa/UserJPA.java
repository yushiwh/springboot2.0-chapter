package com.yuqiyu.chapter13.jpa;

import com.yuqiyu.chapter13.base.BaseRepository;
import com.yuqiyu.chapter13.entity.User;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：恒宇少年
 * Date：2017/4/14
 * Time：23:08
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@Transactional
public interface UserJPA extends BaseRepository<User, Long> {
    /**
     * 查询大于20岁的用户
     */
    @Query(value = "select * from user where age > ?1", nativeQuery = true)
    public List<User> nativeQuery(int age);


    /**
     * //根据用户名、密码删除一条数据
     *
     * @param name
     * @param password
     */
    @Modifying
    @Query(value = "delete from user where name = ?1 and password = ?2", nativeQuery = true)
    public void deleteQuery(String name, String password);
}
