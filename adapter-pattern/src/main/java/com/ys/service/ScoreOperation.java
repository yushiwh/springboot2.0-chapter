package com.ys.service;

/**
 * 抽象成绩操作类：目标接口
 *
 * @author nick
 * @create 2019-04-04 9:45
 */
public interface ScoreOperation {
    /**
     * 成绩排序
     *
     * @param array
     * @return
     */
    public int[] sort(int[] array);

    /**
     * 成绩查找
     *
     * @param array
     * @param key
     * @return
     */
    public int search(int[] array, int key);

}
