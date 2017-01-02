# springboot-jsp 项目技术栈：
Springboot +  JPA + NativeSQL + Shiro + JSP + Bootstrap ，本项目会持续更行更新，也欢迎各位同学一起完善。
<p>使用springboot的好处是可以方便的集成到spring cloud中做分布式微服务。有兴趣的同学可以看我的另一个开源项目：https://git.oschina.net/lostad/spring-cloud-app 也是一个比较简单的入门级微服务Demo
#为什么我选择JPA/Hibernate 而不是 Mybatis：
<p> 首先我本人在开发中习惯于先设计模型，再生成表结构，因为在项目初期的开发过程中，表结构并不稳定，可能经常会根据新有需求进行优化和调整，比如适当追加冗余字段等，个人感觉JPA在使用和后期维护比较方便，JPA同时支持ORM与NativeSQL,灵活性上不亚于Mybatis 。
<p>本人在开发过程中也比较倾向于尽量使用简单映射，PO之间尽量少使用对象映射，复杂查询尽量使用sql,其它操作使用JPA/hiberante.
<p>1、数据持久化完全依赖 JPA/Hibernate ,复杂查询尽量使用BaseJdbcService这个类，以避免可能的性能问题
<p>2、保存和更新推荐使用 spring-data-jpa 提供的接口
<p>3、数据缓存使用Redis，方便集群条件下的session共享以及分布式锁，请在本地安装redis服务：
<p>Linux版本下载地址：
<p>http://www.redis.io/
<p>Windows 名安装版本：
<p>https://github.com/MSOpenTech/redis/releases
