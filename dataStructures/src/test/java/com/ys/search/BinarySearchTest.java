
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
import com.ys.service.search.BinarySearch;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 二分查找查找
 *
 * @author yushi
 * @create 2019/9/5
 * @since 1.0.0
 */
public class BinarySearchTest extends Tester {

    @Autowired
    private BinarySearch binarySearch;

    @Test
    public void testStack() throws Exception {

        //int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};


        //
//		int resIndex = binarySearch.binarySearch(arr, 0, arr.length - 1, 1000);
//		System.out.println("resIndex=" + resIndex);

        List<Integer> resIndexList = binarySearch.binarySearch2(arr, 0, arr.length - 1, 1);
        System.out.println("resIndexList=" + resIndexList);
    }

}