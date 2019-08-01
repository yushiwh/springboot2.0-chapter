/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: BubbleSort
 * Author:   nick
 * Date:     2019/8/1 14:35
 * Description: 冒泡排序
 * History:
 */
package com.ys.service.sort;

import org.springframework.stereotype.Component;

/**
 * 〈冒泡排序〉
 *
 * @author nick
 * @create 2019/8/1
 * @since 1.0.0
 */
@Component
public class BubbleSort {

    /**
     * 冒泡排序的算法方法
     *
     * @param arr
     */
    public void bubbleSort(int[] arr) {
        // 冒泡排序 的时间复杂度 O(n^2), 自己写出
        // 临时变量
        int temp = 0;
        // 标识变量，表示是否进行过交换
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //System.out.println("第" + (i + 1) + "趟排序后的数组");
            //System.out.println(Arrays.toString(arr));

            if (!flag) {
                // 在一趟排序中，一次交换都没有发生过
                break;
            } else {
                // 重置flag!!!, 进行下次判断
                flag = false;
            }
        }
    }

}