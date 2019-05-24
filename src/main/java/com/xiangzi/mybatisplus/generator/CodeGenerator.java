package com.xiangzi.mybatisplus.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * description
 * author:zhangxx
 * Date:2019/5/24
 * Time:11:23
 */
public class CodeGenerator {


    public static void main(String[] args) {
        GlobalConfig config = new GlobalConfig();
        // 全局配置
        String property = System.getProperty("user.dir");
        config.setOutputDir(property + "/src/main/java");
        config.setAuthor("qianjiu");
        config.setIdType(IdType.AUTO); //主键策略
        config.setServiceName("%sService");//生成的service接口名字首字母是否为I，这样设置就没有I
        config.setOpen(false);
        config.setFileOverride(true); //第二次会把第一次的覆盖掉
        config.setBaseResultMap(true); //生成resultMap
        config.setBaseColumnList(true); //在xml中生成基础列

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatis_plus?useUnicode=true&useSSL=true&characterEncoding=utf8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");

        //3、策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)//开启全局大写命名
                .setNaming(NamingStrategy.underline_to_camel)//下划线到驼峰的命名方式
//                .setTablePrefix("sys_")//表名前缀
                .setEntityLombokModel(true)//使用lombok
                .setInclude("sys_user");//逆向工程使用的表

        //4、包名策略配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.xiangzi.mybatisplus")//设置包名的parent
                .setMapper("dao")
                .setService("service")
                .setController("controller")
                .setEntity("model")
                .setXml("mapper");//设置xml文件的目录

        //5、整合配置
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setGlobalConfig(config)
                .setDataSource(dsc)
                .setStrategy(strategyConfig)
                .setPackageInfo(packageConfig);

        //6、执行
        autoGenerator.execute();
    }
}
