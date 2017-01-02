# springboot-jsp 项目技术栈：
Springboot +  JPA + NativeSQL + Shiro + JSP + Bootstrap
#关于JPA/Hibernate 和 Mybatis之争：
<p>个人感觉hibernate在使用中尤其是后期维护，要比mybatis方便，JPA同时支持ORM与NativeSQL,灵活性上不亚于Mybatis 。
<p>我本人在开发过程中也比较倾向于尽量使用简单映射，PO之间尽量少使用对象映射，复杂查询尽量使用sql,其它操作使用JPA/hiberante.
<p>1、数据持久化完全依赖hibernate ,查询时尽量使用BaseJdbcService这个类，以避免可能的性能问题
<p>2、保存和更新推荐使用hibernate
<p>3、数据缓存使用redis，方便集群条件下的session共享以及分布式锁，请在本地安装redis服务：
<p>Linux版本下载地址：
<p>http://www.redis.io/
<p>Windows 名安装版本：
<p>https://github.com/MSOpenTech/redis/releases
