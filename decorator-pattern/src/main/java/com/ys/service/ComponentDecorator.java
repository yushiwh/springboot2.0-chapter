/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: ComponentDecorator
 * Author:   yushi
 * Date:     2019/4/19 10:16
 * Description: 构件装饰类：抽象装饰类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 〈构件装饰类：抽象装饰类〉
 * 相当于在原来的构件上面加上了一层壳子，供客户端直接调用
 *
 * @author yushi
 * @create 2019/4/19
 * @since 1.0.0
 */
public class ComponentDecorator extends Component {
    private static final Logger logger = LoggerFactory.getLogger(ComponentDecorator.class);
    /**
     * 维持对抽象构件类型对象的引用
     */
    private Component component;

    /**
     * 注入抽象构件类型的对象
     */
    public ComponentDecorator(Component component) {
        this.component = component;
    }

    @Override
    public void display() {
        component.display();
    }
}