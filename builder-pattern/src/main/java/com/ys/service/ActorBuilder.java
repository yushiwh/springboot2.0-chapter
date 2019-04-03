/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: ActorBuilder
 * Author:   yushi
 * Date:     2019/4/3 14:21
 * Description: 角色建造器：抽象建造者
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈角色建造器：抽象建造者〉
 *
 * @author yushi
 * @create 2019/4/3
 * @since 1.0.0
 */
public abstract class ActorBuilder {
    protected Actor actor = new Actor();

    public abstract void buildType();

    public abstract void buildSex();

    public abstract void buildFace();

    public abstract void buildCostume();

    public abstract void buildHairstyle();

    /**
     * 工厂方法，返回一个完整的游戏角色对象
     * 定义了调用的次序，是一个流程的模版的方法
     */
    public Actor createActor() {
        this.buildType();
        this.buildSex();
        this.buildFace();
        this.buildCostume();
        this.buildHairstyle();
        return actor;
    }
}