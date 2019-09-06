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
import com.ys.service.search.InsertValueSearch;
import com.ys.service.search.SeqSearch;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 插值查找
 *
 * @author yushi
 * @create 2019/9/5
 * @since 1.0.0
 */

public class InsertValueSearchTest extends Tester {

    @Autowired
    private InsertValueSearch insertValueSearch;

    @Test
    public void testStack() throws Exception {
     //   int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        int index = insertValueSearch.insertValueSearch(arr, 0, arr.length - 1, 11);
        //int index = binarySearch(arr, 0, arr.length, 1);
        System.out.println("index = " + index);
        //System.out.println(Arrays.toString(arr));


    }

}