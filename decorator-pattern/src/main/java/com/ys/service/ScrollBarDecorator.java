/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: ScrollBarDecorator
 * Author:   yushi
 * Date:     2019/4/19 10:19
 * Description: 滚动条装饰类：具体装饰类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 〈滚动条装饰类：具体装饰类〉
 *
 * @author yushi
 * @create 2019/4/19
 * @since 1.0.0
 */
public class ScrollBarDecorator extends ComponentDecorator {

    private static final Logger logger = LoggerFactory.getLogger(ScrollBarDecorator.class);

    /**
     * 注入抽象构件类型的对象
     *
     * @param component
     */
    public ScrollBarDecorator(Component component) {
        super(component);
    }

    /**
     * 下面相当于是自己的方法
     */
    @Override
    public void display() {
        this.setScrollBar();
        super.display();
    }

    public void setScrollBar() {
        logger.info("为构件增加滚动条");
    }
}