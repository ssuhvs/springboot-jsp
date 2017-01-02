1、数据持久化完全依赖hibernate ,查询时尽量使用BaseJdbcService这个类，以避免可能的性能问题
2、保存和更新推荐使用hibernate
3、请在本地安装redis服务：
Linux版本下载地址：
http://www.redis.io/
Windows 名安装版本：
https://github.com/MSOpenTech/redis/releases