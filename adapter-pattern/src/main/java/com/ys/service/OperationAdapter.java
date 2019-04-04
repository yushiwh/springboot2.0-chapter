/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: OperationAdapter
 * Author:   yushi
 * Date:     2019/4/4 9:52
 * Description: 操作适配器：适配器
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈操作适配器：适配器〉
 *
 * @author yushi
 * @create 2019/4/4
 * @since 1.0.0
 */
public class OperationAdapter implements ScoreOperation {

    /**
     * 定义适配者QuickSort对象
     */
    private QuickSort sortObj;
    /**
     * 定义适配者BinarySearch对象
     */
    private BinarySearch searchObj;

    public OperationAdapter() {
        sortObj = new QuickSort();
        searchObj = new BinarySearch();
    }

    /**
     * //调用适配者类QuickSort的排序方法
     *
     * @param array
     * @return
     */
    @Override
    public int[] sort(int[] array) {
        return sortObj.quickSort(array);
    }

    /**
     * //调用适配者类BinarySearch的查找方法
     *
     * @param array
     * @param key
     * @return
     */
    @Override
    public int search(int[] array, int key) {
        return searchObj.binarySearch(array, key);
    }

}