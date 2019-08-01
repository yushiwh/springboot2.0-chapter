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
import com.ys.service.stack.ArrayStack2;
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
public class BubbleSortTest extends Tester {

    @Autowired
    private BubbleSort bubbleSort;

    @Test
    public void testStack() throws Exception {
        //		int arr[] = {3, 9, -1, 10, 20};
//
//		System.out.println("排序前");
//		System.out.println(Arrays.toString(arr));

        //为了容量理解，我们把冒泡排序的演变过程，给大家展示

        //测试一下冒泡排序的速度O(n^2), 给80000个数据，测试
        //创建要给80000个的随机的数组
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000); //生成一个[0, 8000000) 数
        }

        Date data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是=" + date1Str);

        //测试冒泡排序
        bubbleSort.bubbleSort(arr);

        Date data2 = new Date();
        String date2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间是=" + date2Str);

        //System.out.println("排序后");
        //System.out.println(Arrays.toString(arr));


		/*

		// 第二趟排序，就是将第二大的数排在倒数第二位

		for (int j = 0; j < arr.length - 1 - 1 ; j++) {
			// 如果前面的数比后面的数大，则交换
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}

		System.out.println("第二趟排序后的数组");
		System.out.println(Arrays.toString(arr));


		// 第三趟排序，就是将第三大的数排在倒数第三位

		for (int j = 0; j < arr.length - 1 - 2; j++) {
			// 如果前面的数比后面的数大，则交换
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}

		System.out.println("第三趟排序后的数组");
		System.out.println(Arrays.toString(arr));

		// 第四趟排序，就是将第4大的数排在倒数第4位

		for (int j = 0; j < arr.length - 1 - 3; j++) {
			// 如果前面的数比后面的数大，则交换
			if (arr[j] > arr[j + 1]) {
				temp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = temp;
			}
		}

		System.out.println("第四趟排序后的数组");
		System.out.println(Arrays.toString(arr)); */


    }


}