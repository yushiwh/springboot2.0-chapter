/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: HeroBuilder
 * Author:   yushi
 * Date:     2019/4/3 14:23
 * Description: 英雄角色建造器：具体建造者
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈英雄角色建造器：具体建造者〉
 *
 * @author yushi
 * @create 2019/4/3
 * @since 1.0.0
 */
public class HeroBuilder extends ActorBuilder {

    @Override
    public void buildType() {
        actor.setType("英雄");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildFace() {
        actor.setFace("英俊");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("盔甲");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("飘逸");
    }
}