定时任务在企业项目比较常用到，几乎所有的项目都会牵扯该功能模块，定时任务一般会处理指定时间点执行某一些业务逻辑、间隔时间执行某一些业务逻辑等。



我们本章将会采用外置的quartz定时任务框架来完成定时任务的分布式单节点持久化，我们为什么要持久化定时任务呢？

在一些项目中定时任务可能是必不可少的，由于某种特殊的原因定时任务可能丢失，如重启定时任务服务项目后，
原内存中的定时任务就会被完全释放！那对于我们来说可能是致命的问题。当然也有强制的办法解决这类问题，
但是如果我们把定时任务持久化到数据库，像维护普通逻辑数据那样维护任务，就会避免项目中遇到的种种的特殊情况。
 
 
 
 由于我们quartz-cluster-node-first的商品库存检查定时任务是每隔30秒执行一次，所以任务除非手动清除否则是不会被清空的
 
 
 
 一台运行——就是基于SpringBoot & Quartz完成定时任务分布式单节点持久化
 多台运行——基于SpringBoot & Quartz完成定时任务分布式多节点负载持久化（注意要修改一下对应的启动的端口，因为上面的任务不会清除）
 
 https://www.jianshu.com/p/d52d62fb2ac6   Quartz完成定时任务分布式单节点持久化
 https://www.jianshu.com/p/49133c107143   Quartz完成定时任务分布式多节点负载持久化
 
 
 
 ----------------下面是自己的一些理解，以免后面继续踩坑--------------------------
 一、quartz定时任务框架完成定时任务的持久化
 好处：可以保证定时任务的执行，重启后不会丢失
 
 二、如果quartz采用的是Schedule("0/30 * * * * ?")这样方式，定时任务是不会取消的，反之则是执行后自动从数据库取消掉
 
 三、quartz也有自己的配置文件，和对应的表，直接复制即可。配置文件中的参数支持分布式运用
 
 四、分布式运用中，可以自动的接管其他的程序运行的定时任务，实现定时任务的漂移
 如：启动29-1（first）和29（second）两台，注意修改不同的端口号
 执行test里面的单元测试方法，添加商品
 
 first的日志：
 2018-04-27 19:02:36.009  INFO 11140 --- [           main] com.hengyu.chapter39.QuartzApplication   : 【【【【【【定时任务分布式节点 - quartz-cluster-node-first 已启动】】】】】】
 2018-04-27 19:02:37.973  INFO 11140 --- [lerFactoryBean]] o.s.s.quartz.SchedulerFactoryBean        : Starting Quartz Scheduler now, after delay of 2 seconds
 2018-04-27 19:02:38.084  INFO 11140 --- [lerFactoryBean]] org.quartz.core.QuartzScheduler          : Scheduler schedulerFactoryBean_$_PC-20141125VBTK1524826954621 started.
 2018-04-27 19:04:30.702  INFO 11140 --- [ryBean_Worker-1] c.hengyu.chapter39.timers.GoodAddTimer   : 分布式节点quartz-cluster-node-first，商品添加完成后执行任务，任务时间：Fri Apr 27 19:04:30 CST 2018
 2018-04-27 19:05:30.918  INFO 11140 --- [ryBean_Worker-2] c.h.c.timers.GoodSecKillRemindTimer      : 分布式节点quartz-cluster-node-first，开始处理秒杀商品：5，关注用户推送消息.
 2018-04-27 19:06:28.316  INFO 11140 --- [_ClusterManager] o.s.s.quartz.LocalDataSourceJobStore     : ClusterManager: detected 1 failed or restarted instances.
 2018-04-27 19:06:28.316  INFO 11140 --- [_ClusterManager] o.s.s.quartz.LocalDataSourceJobStore     : ClusterManager: Scanning for instance "PC-20141125VBTK1524826981495"'s failed in-progress jobs.
 2018-04-27 19:06:28.383  INFO 11140 --- [_ClusterManager] o.s.s.quartz.LocalDataSourceJobStore     : ClusterManager: ......Freed 1 acquired trigger(s).
 2018-04-27 19:06:30.080  INFO 11140 --- [ryBean_Worker-3] c.h.c.timers.GoodStockCheckTimer         : 分布式节点quartz-cluster-node-first，执行库存检查定时任务，执行时间：Fri Apr 27 19:06:30 CST 2018
 2018-04-27 19:07:00.088  INFO 11140 --- [ryBean_Worker-4] c.h.c.timers.GoodStockCheckTimer         : 分布式节点quartz-cluster-node-first，执行库存检查定时任务，执行时间：Fri Apr 27 19:07:00 CST 2018
 2018-04-27 19:07:30.072  INFO 11140 --- [ryBean_Worker-5] c.h.c.timers.GoodStockCheckTimer         : 分布式节点quartz-cluster-node-first，执行库存检查定时任务，执行时间：Fri Apr 27 19:07:30 CST 2018 
 
 second的日志
 2018-04-27 19:03:03.077  INFO 9180 --- [           main] c.h.chapter39.QuartzSecondApplication    : 【【【【【【定时任务分布式节点 - quartz-cluster-node-second 已启动】】】】】】
 2018-04-27 19:03:05.024  INFO 9180 --- [lerFactoryBean]] o.s.s.quartz.SchedulerFactoryBean        : Starting Quartz Scheduler now, after delay of 2 seconds
 2018-04-27 19:03:05.088  INFO 9180 --- [lerFactoryBean]] org.quartz.core.QuartzScheduler          : Scheduler schedulerFactoryBean_$_PC-20141125VBTK1524826981495 started.
 2018-04-27 19:03:56.311  INFO 9180 --- [ryBean_Worker-1] c.h.c.timers.GoodStockCheckTimer         : 分布式节点quartz-cluster-node-second，执行库存检查定时任务，执行时间：Fri Apr 27 19:03:56 CST 2018
 2018-04-27 19:04:00.079  INFO 9180 --- [ryBean_Worker-2] c.h.c.timers.GoodStockCheckTimer         : 分布式节点quartz-cluster-node-second，执行库存检查定时任务，执行时间：Fri Apr 27 19:04:00 CST 2018
 2018-04-27 19:04:30.140  INFO 9180 --- [ryBean_Worker-3] c.h.c.timers.GoodStockCheckTimer         : 分布式节点quartz-cluster-node-second，执行库存检查定时任务，执行时间：Fri Apr 27 19:04:30 CST 2018
 2018-04-27 19:05:00.069  INFO 9180 --- [ryBean_Worker-4] c.h.c.timers.GoodStockCheckTimer         : 分布式节点quartz-cluster-node-second，执行库存检查定时任务，执行时间：Fri Apr 27 19:05:00 CST 2018
 2018-04-27 19:05:30.106  INFO 9180 --- [ryBean_Worker-5] c.h.c.timers.GoodStockCheckTimer         : 分布式节点quartz-cluster-node-second，执行库存检查定时任务，执行时间：Fri Apr 27 19:05:30 CST 2018
 2018-04-27 19:06:00.062  INFO 9180 --- [ryBean_Worker-6] c.h.c.timers.GoodStockCheckTimer         : 分布式节点quartz-cluster-node-second，执行库存检查定时任务，执行时间：Fri Apr 27 19:06:00 CST 2018
 
 
 
 关闭后的第二台被第一台接管定时任务，实现漂移的效果