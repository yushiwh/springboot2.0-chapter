/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: ArrayStack2
 * Author:   nick
 * Date:     2019/7/5 10:51
 * Description: 定义一个 ArrayStack2 表示栈, 需要扩展功能
 * History:
 */
package com.ys.service.stack;

/**
 * 〈定义一个 ArrayStack2 表示栈, 需要扩展功能〉
 *
 * @author nick
 * @create 2019/7/5
 * @since 1.0.0
 */
public class ArrayStack2 {
    /**
     * 栈的大小
     */
    private int maxSize;
    /**
     * 数组，数组模拟栈，数据就放在该数组
     */
    private int[] stack;
    /**
     * top表示栈顶，初始化为-1
     */
    private int top = -1;

    /**
     * 构造器
     */
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    /**
     * 增加一个方法，可以返回当前栈顶的值, 但是不是真正的pop
     */
    public int peek() {
        return stack[top];
    }

    /**
     * 栈满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 栈空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 入栈-push
     */
    public void push(int value) {
        //先判断栈是否满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    /**
     * 出栈-pop, 将栈顶的数据返回
     */
    public int pop() {
        //先判断栈是否空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 显示栈的情况[遍历栈]， 遍历时，需要从栈顶开始显示数据
     */
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~~");
            return;
        }
        //需要从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级，优先级是程序员来确定, 优先级使用数字表示

    /**
     * 数字越大，则优先级就越高.
     */

    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            // 假定目前的表达式只有 +, - , * , /
            return -1;
        }
    }

    /**
     * 判断是不是一个运算符
     */
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算方法
     */
    public int cal(int num1, int num2, int oper) {
        // res 用于存放计算的结果
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                // 注意顺序
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}