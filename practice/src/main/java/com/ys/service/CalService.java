package com.ys.service;

import java.util.List;

/**
 * @author nick
 * @create 2019-05-15 14:23
 */
public interface CalService {



    /**
     * 返回所有的符合规则的计算题
     *
     * @return
     */
    public List<String> calStr();


    /**
     * 根据传递的参数，得到是几个数进行计算 生成一道题目
     *
     * @return
     */
    public String createStr();


}
