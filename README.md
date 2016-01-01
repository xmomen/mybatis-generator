# 使用说明

##  generatorConfig.xml 配置示例（可根据业务自定义）
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE generatorConfiguration PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
        "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd" >
<generatorConfiguration>
    <classPathEntry location="E:\MavenRepositories\mysql\mysql-connector-java\5.1.31\mysql-connector-java-5.1.31.jar" />
    <context id="context1"
             targetRuntime="com.xmomen.maven.plugins.mybatis.generator.context.IntrospectedTableMyBatis3ImplExt">

        <plugin type="com.xmomen.maven.plugins.mybatis.generator.plugins.ModelAnnotationPlugin" />
        <plugin type="com.xmomen.maven.plugins.mybatis.generator.plugins.MapperSqlMapGeneratorPlugin" />
        <plugin type="com.xmomen.maven.plugins.mybatis.generator.plugins.PrimaryKeyGeneratorPlugin" />
        <plugin type="com.xmomen.maven.plugins.mybatis.generator.plugins.MapperGeneratorPlugin">
            <property name="rootInterface" value="com.xmomen.framework.mybatis.mapper.MybatisMapper"/>
        </plugin>
        <plugin type="com.xmomen.maven.plugins.mybatis.generator.plugins.ModelExamplePlugin" >
            <property name="rootClass" value="com.xmomen.framework.mybatis.model.BaseMybatisExample" />
        </plugin>

        <commentGenerator>
            <property name="suppressAllComments" value="true" />
            <property name="suppressDate" value="true" />
        </commentGenerator>

        <jdbcConnection driverClass="com.mysql.jdbc.Driver"
                        connectionURL="jdbc:mysql://127.0.0.1:3306/demo?useUnicode=true&amp;characterEncoding=UTF-8"
                        userId="admin" password="admin" />

        <javaTypeResolver type="com.xmomen.maven.plugins.mybatis.generator.plugins.types.JavaTypeResolverDefaultImplExt"></javaTypeResolver>

        <javaModelGenerator targetPackage="com.xmomen.demo.entity"
                            targetProject=".\src\test\java" >
            <property name="rootClass" value="com.xmomen.framework.mybatis.model.BaseMybatisModel" />
        </javaModelGenerator>

        <sqlMapGenerator targetPackage="com.xmomen.demo.entity.mapper"
                         targetProject=".\src\test\resources" />
        <javaClientGenerator targetPackage="com.xmomen.demo.entity.mapper"
                            targetProject=".\src\test\java" type="XMLMAPPER" >
        </javaClientGenerator>
        <table tableName="t_department" />
        <table tableName="t_employee" />

    </context>
</generatorConfiguration>
```


## POM.xml 配置
``` xml
...
<plugin>
    <groupId>org.mybatis.generator</groupId>
    <artifactId>mybatis-generator-maven-plugin</artifactId>
    <version>1.3.0</version>
    <dependencies>
        <dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <version>1.3.2</version>
        </dependency>
        <dependency>
            <groupId>com.xmomen.maven.plugins</groupId>
            <artifactId>mybatis-generator</artifactId>
            <version>1.0.0-SNAPSHOT</version>
        </dependency>
    </dependencies>
    <configuration>
        <configurationFile>src/main/resources/tools/generatorConfig.xml</configurationFile>
        <verbose>true</verbose>
        <overwrite>true</overwrite>
    </configuration>
</plugin>
...
```
