/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: AngelBuilder
 * Author:   yushi
 * Date:     2019/4/3 14:25
 * Description: 天使角色建造器：具体建造者
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈天使角色建造器：具体建造者〉
 *
 * @author yushi
 * @create 2019/4/3
 * @since 1.0.0
 */
public class AngelBuilder extends ActorBuilder {

    @Override
    public void buildType() {
        actor.setType("天使");
    }

    @Override
    public void buildSex() {
        actor.setSex("女");
    }

    @Override
    public void buildFace() {
        actor.setFace("漂亮");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("白裙");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("披肩长发");
    }
}