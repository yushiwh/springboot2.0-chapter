/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: DevilBuilder
 * Author:   yushi
 * Date:     2019/4/3 14:26
 * Description: 恶魔角色建造器：具体建造者
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈恶魔角色建造器：具体建造者〉
 *
 * @author yushi
 * @create 2019/4/3
 * @since 1.0.0
 */
public class DevilBuilder extends ActorBuilder {

    @Override
    public void buildType() {
        actor.setType("恶魔");
    }

    @Override
    public void buildSex() {
        actor.setSex("妖");
    }

    @Override
    public void buildFace() {
        actor.setFace("丑陋");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("黑衣");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("光头");
    }
}