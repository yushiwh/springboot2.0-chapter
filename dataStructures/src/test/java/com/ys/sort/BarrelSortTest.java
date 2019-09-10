/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: BarrelSortTest
 * Author:   nick
 * Date:     2019/9/10 8:58
 * Description: 桶排序测试
 * History:
 */
package com.ys.sort;

import com.ys.Tester;
import com.ys.service.sort.BarrelSort;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 〈桶排序测试〉
 *
 * @author nick
 * @create 2019/9/10
 * @since 1.0.0
 */
public class BarrelSortTest extends Tester {

    @Autowired
    private BarrelSort barrelSort;


    @Test
    public void testStack() throws Exception {
        int[] arr = {101, 34, 119, 1, 1, 89};
        System.out.println("~~~原始数组为~~~" );
        System.out.println(Arrays.toString(arr));
        int[] barrel = barrelSort.barrelSort(arr);


//        //测试一下排序的速度 80w
//        int[] arr = new int[800000];
//        for (int i = 0; i < 800000; i++) {
//            arr[i] = (int) (Math.random() * 800000); // 生成一个[0, 8000000) 数
//        }
//
//        System.out.println("排序前");
//        Date data1 = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date1Str = simpleDateFormat.format(data1);
//        System.out.println("排序前的时间是=" + date1Str);
//
//        //测试桶排序
//        int[] barrel = barrelSort.barrelSort(arr);
//
//        Date data2 = new Date();
//        String date2Str = simpleDateFormat.format(data2);
//        System.out.println("排序后的时间是=" + date2Str);


        //按照顺序进行打印，出现几次就打印几次
        System.out.println("~~~~~原始数组为~~~~");
        for (int i = 0; i < barrel.length; i++) {
            for (int j = 0; j < barrel[i]; j++) {
                //可以有效的去掉0的输出
                System.out.print(" " + i+",");
            }
        }

    }
}