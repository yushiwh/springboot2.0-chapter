/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: LoadBalancer
 * Author:   yushi
 * Date:     2019/4/1 11:04
 * Description: 负载均衡器LoadBalancer
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * <p>
 * <p>
 * <p>
 * 将负载均衡器LoadBalancer设计为单例类，其中包含一个存储服务器信息的集合serverList，每次在serverList 中随机选择一台服务器来响应客户端的请求
 */

package com.ys.service;

import java.util.ArrayList;
import java.util.Random;

import java.util.*;

/**
 * 〈负载均衡器LoadBalancer〉
 * 负载均衡器LoadBalancer：单例类，真实环境下该类将非常复杂，包括大量初始化的工作和业务方法，考虑到代码的可读性和易理解性，只列出部分与模式相关的核心代码
 *
 * @author yushi
 * @create 2019/4/1
 * @since 1.0.0
 */
public class LoadBalancer {

    //私有静态成员变量，存储唯一实例
    private static LoadBalancer instance = null;
    //服务器集合
    private List serverList = null;

    //私有构造函数
    private LoadBalancer() {
        serverList = new ArrayList();
    }

    //公有静态成员方法，返回唯一实例
    public static LoadBalancer getLoadBalancer() {
        if (instance == null) {
            instance = new LoadBalancer();
        }
        return instance;
    }

    //增加服务器
    public void addServer(String server) {
        serverList.add(server);
    }

    //删除服务器
    public void removeServer(String server) {
        serverList.remove(server);
    }

    //使用Random类随机获取服务器
    public String getServer() {
        Random random = new Random();
        int i = random.nextInt(serverList.size());
        return (String) serverList.get(i);
    }
}