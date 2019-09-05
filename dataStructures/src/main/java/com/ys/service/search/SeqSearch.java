/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: BubbleSort
 * Author:   nick
 * Date:     2019/8/1 14:35
 * Description: 冒泡排序
 * History:
 */
package com.ys.service.search;

import org.springframework.stereotype.Component;

/**
 * 线性查找
 *
 * @author nick
 * @create 2019/9/5
 * @since 1.0.0
 */
@Component
public class SeqSearch {
    /**
     * 这里我们实现的线性查找是找到一个满足条件的值，就返回
     *
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr, int value) {
        // 线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}