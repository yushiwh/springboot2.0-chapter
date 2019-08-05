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
package com.ys.sort;

import com.ys.Tester;
import com.ys.service.sort.BubbleSort;
import com.ys.service.sort.SelectSort;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 冒泡排序的测试
 *
 * @author yushi
 * @create 2019/7/5
 * @since 1.0.0
 */
public class SelectSortTest extends Tester {

    @Autowired
    private SelectSort selectSort;

    @Test
    public void testStack() throws Exception {
        //int [] arr = {101, 34, 119, 1, -1, 90, 123};

        //创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
        }

        System.out.println("排序前");
        //System.out.println(Arrays.toString(arr));

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        selectSort.selectSort(arr);


        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序前的时间是=" + date2Str);

        //System.out.println("排序后");
        //System.out.println(Arrays.toString(arr));


    }


}