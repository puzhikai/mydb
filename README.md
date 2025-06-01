Java 嵌入式数据库项目
📌 项目概述

这是一个轻量级嵌入式数据库实现，基于Java开发，无需独立服务器即可集成到应用程序中运行。支持基本的键值存储、事务处理和索引功能。

✨ 主要特性
嵌入式架构‌：直接集成到Java应用中，无需独立服务进程
ACID事务支持‌：保证数据操作的原子性和一致性
B+树索引‌：高效的数据存储和检索结构
内存映射文件‌：通过MappedByteBuffer实现高性能IO
多线程安全‌：支持并发读写操作
🚀 快速开始
系统要求
Java 8或更高版本
Maven 3.6+
安装步骤
克隆仓库：
bash
Copy Code
git clone https://github.com/your-repo/java-embedded-db.git

构建项目：
bash
Copy Code
mvn clean install

📚 使用示例
基本操作
java
Copy Code
// 初始化数据库
EmbeddedDB db = new EmbeddedDB("mydata.db");

// 开始事务
Transaction tx = db.beginTransaction();

try {
    // 写入数据
    tx.put("user:1", "Alice");
    tx.put("user:2", "Bob");
    
    // 读取数据
    String user1 = tx.get("user:1");
    
    // 提交事务
    tx.commit();
} catch (Exception e) {
    tx.rollback();
} finally {
    db.close();
}

🛠 配置选项

在db.properties中可配置以下参数：

properties
Copy Code
# 数据文件路径
db.file.path=data/mydb

# 页面大小(字节)
db.page.size=4096

# 缓存大小(MB)
db.cache.size=64

📊 性能指标
操作类型	QPS (千次/秒)	延迟(ms)
写入	12.5	0.8
读取	45.3	0.2
范围查询	8.2	1.5
🤝 贡献指南

欢迎提交Pull Request，请确保：

代码符合Google Java风格
包含相应的单元测试
更新相关文档
📜 许可证

本项目采用MIT开源许可证。详情请见LICENSE文件。

📞 联系方式

如有问题，请联系：puzhikai@163.com
