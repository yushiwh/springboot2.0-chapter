/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: ArrayQueue
 * Author:   nick
 * Date:     2019/6/26 10:09
 * Description: 使用
 * History:
 */
package com.ys.service.queue;

/**
 *
 * 使用数组模拟队列-编写一个ArrayQueue类
 *
 * @author nick
 * @create 2019/6/26
 * @since 1.0.0
 */
public class ArrayQueue {
    /**
     * // 表示数组的最大容量
     */
    private int maxSize;
    /**
     * // 队列头
     */
    private int front;
    /**
     * // 队列尾
     */
    private int rear;
    /**
     * // 该数据用于存放数据, 模拟队列
     */
    private int[] arr;

    /**
     * // 创建队列的构造器
     *
     * @param arrMaxSize
     */

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        /**
         * // 指向队列头部，分析出front是指向队列头的前一个位置.
         */
        front = -1;
        /**
         * // 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
         */
        rear = -1;
    }

    /**
     * 判断队列是否满
     */
    public boolean isFull() {
        return rear == maxSize - 1;
    }


    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }


    /**
     * 添加数据到队列
     *
     * @param n
     */
    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入数据~");
            return;
        }
        // 让rear 后移
        rear++;
        arr[rear] = n;
    }

    /**
     * 获取队列的数据, 出队列
     */

    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        front++; // front后移
        return arr[front];

    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    /**
     * 显示队列的头数据， 注意不是取出数据
     */
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[front + 1];
    }
}