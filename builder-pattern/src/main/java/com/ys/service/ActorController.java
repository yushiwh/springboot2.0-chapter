/**
 * Copyright (C), 2018-2020, 998电商集团
 * FileName: ActorController
 * Author:   yushi
 * Date:     2019/4/3 14:29
 * Description: 游戏角色创建控制器：指挥者
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.ys.service;

/**
 * 〈游戏角色创建控制器：指挥者〉
 *
 * @author yushi
 * @create 2019/4/3
 * @since 1.0.0
 */
public class ActorController {
    /**
     * 逐步构建复杂产品对象
     */
    public Actor construct(ActorBuilder ab) {
        Actor actor;
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        ab.buildHairstyle();
        actor = ab.createActor();
        return actor;
    }
}