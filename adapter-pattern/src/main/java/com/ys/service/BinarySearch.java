/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: BinarySearch
 * Author:   yushi
 * Date:     2019/4/4 9:51
 * Description: 二分查找类：适配者
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈二分查找类：适配者〉
 * 两个已有的算法类
 *
 * @author yushi
 * @create 2019/4/4
 * @since 1.0.0
 */
public class BinarySearch {
    public int binarySearch(int array[], int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int midVal = array[mid];
            if (midVal < key) {
                low = mid + 1;
            } else if (midVal > key) {
                high = mid - 1;
            } else {
                //找到元素返回1
                return 1;
            }
        }
        //未找到元素返回-1
        return -1;
    }

}