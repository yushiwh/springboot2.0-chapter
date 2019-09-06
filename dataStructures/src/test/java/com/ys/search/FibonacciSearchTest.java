/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: sparsearray
 * Author:   yushi
 * Date:     2019/6/20 14:59
 * Description: 稀疏数组测试
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.search;

import com.ys.Tester;
import com.ys.service.search.FibonacciSearch;
import com.ys.service.search.SeqSearch;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 斐波那契查找
 *
 * @author yushi
 * @create 2019/9/6
 * @since 1.0.0
 */
public class FibonacciSearchTest extends Tester {

    @Autowired
    private FibonacciSearch fibonacciSearch;

    @Test
    public void testStack() throws Exception {

        int[] arr = {1, 8, 10, 89, 1000, 1234};

        System.out.println("index=" + fibonacciSearch.fibSearch(arr, 1234));// 0

    }

}