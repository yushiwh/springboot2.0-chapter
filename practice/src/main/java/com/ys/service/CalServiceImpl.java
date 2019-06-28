/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: CalServiceImpl
 * Author:   yushi
 * Date:     2019/5/15 14:28
 * Description: 计算题生成
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

import com.ys.controller.Client;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 〈计算题生成〉
 *
 * @author yushi
 * @create 2019/5/15
 * @since 1.0.0
 */
@Service
@Slf4j
public class CalServiceImpl implements CalService {
    private static final Logger logger = LoggerFactory.getLogger(CalServiceImpl.class);
    @Value("${cal.param}")
    Integer calParam;
    @Value("${cal.count}")
    Integer calCount;


    @Override
    public List<String> calStr() {
        List<String> list = new ArrayList<>();

        String str = "";

        //直接循环，得到对应的个数
        while (list.size() < 100) {
            str = createStr();
            if (str != "") {
                list.add(str);
            }
        }

        return list;
    }

    /**
     * 生成一道题目，
     *
     * @return
     */
    @Override
    public String createStr() {

        String cal = "";


        List<String> fhs = new ArrayList<>();
        fhs.add("+");
        fhs.add("-");

        List<Integer> strList = new ArrayList<>();

        //生成规定的数，并且加入到一个集合中
        for (int i = 0; i < calParam; i++) {
            strList.add((int) (Math.random() * 100));
        }
        double result = 0;
        String temp = "";
        String str = "";
        //组合成计算式
        for (int j = 0; j < strList.size(); j++) {
            if (j < strList.size() - 1) {
                temp = cal + strList.get(j);
                cal += strList.get(j) + getRandomList(fhs, 1).get(0).toString();
            } else {
                cal += strList.get(j);
                temp = cal;
                str = cal;
            }

            //调用一下结果是否>100和<0
            result = Calculator.conversion(temp);
            logger.info("表达式=" + temp + "-->结果：" + result);
            if (result > 100 || result < 0) {
                break;
            }
        }

        logger.info("最终的计算表达式=" + str);
        return str;
    }


    public List getRandomList(List<String> paramList, int count) {
        if (count == 0) {
            return null;
        }
        Random random = new Random();
        List<Integer> tempList = new ArrayList<Integer>();//临时存放产生的list索引，去除重复的索引
        List newList = new ArrayList();//生成新的list集合
        int temp = 0;
        if (count <= 1) {//如果数据小于1，取一条数据
            temp = random.nextInt(paramList.size());
            newList.add(paramList.get(temp));
        } else {
            for (int i = 0; i < Math.ceil(count); i++) {
                temp = random.nextInt(paramList.size());//初始化一个随机数，将产生的随机数作为被抽list的索引
                if (!tempList.contains(temp)) {//判断随机抽取的随机数
                    tempList.add(temp);
                    newList.add(paramList.get(temp));
                } else {
                    i--;
                }
            }
        }
        return newList;
    }


}