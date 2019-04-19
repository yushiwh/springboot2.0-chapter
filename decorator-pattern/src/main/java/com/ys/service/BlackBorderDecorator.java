/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: BlackBorderDecorator
 * Author:   yushi
 * Date:     2019/4/19 10:23
 * Description: 黑色边框装饰类：具体装饰类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 〈黑色边框装饰类：具体装饰类〉
 *
 * @author yushi
 * @create 2019/4/19
 * @since 1.0.0
 */
public class BlackBorderDecorator extends ComponentDecorator {
    private static final Logger logger = LoggerFactory.getLogger(BlackBorderDecorator.class);

    /**
     * 注入抽象构件类型的对象
     *
     * @param component
     */
    public BlackBorderDecorator(Component component) {
        super(component);
    }


    public void setBlackBoard() {
        logger.info("为构件增加黑色边框！");
    }


    @Override
    public void display() {
        this.setBlackBoard();
        super.display();
    }
}