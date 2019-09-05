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
import com.ys.service.search.SeqSearch;
import com.ys.service.sort.BubbleSort;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线性查找
 *
 * @author yushi
 * @create 2019/9/5
 * @since 1.0.0
 */
public class SeqSearchTest extends Tester {

    @Autowired
    private SeqSearch seqSearch;

    @Test
    public void testStack() throws Exception {

        int arr[] = {1, 9, 11, -1, 34, 89};// 没有顺序的数组
        int index = seqSearch.seqSearch(arr, -1);
        if (index == -1) {
            System.out.println("没有找到");
        } else {
            System.out.println("找到，下标为=" + index);
        }

    }

}