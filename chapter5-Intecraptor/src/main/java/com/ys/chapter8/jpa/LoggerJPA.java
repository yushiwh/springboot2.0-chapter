package com.ys.chapter8.jpa;


import com.ys.chapter8.entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 请求日志数据接口
 * ========================
 * Created with IntelliJ IDEA.
 * User：ys
 * Date：2018/4/10
 * Time：21:06
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
public interface LoggerJPA
        extends JpaRepository<LoggerEntity,Long>
{

}
