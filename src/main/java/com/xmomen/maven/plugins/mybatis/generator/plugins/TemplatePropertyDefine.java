package com.xmomen.maven.plugins.mybatis.generator.plugins;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by tanxinzheng on 16/8/28.
 */
public @Data class TemplatePropertyDefine {
    // 表名
    private String tableName;
    // 类名
    private String className;
    // 表名注释
    private String tableComment;
    // 业务领域对象名称
    private String domainObjectName;
    /** 领域对象类 */
    private String domainObjectClass;
    // 模板文件路径
    private String templateFilePath;
    // 模板文件名
    private String templateFileName;
    // 目标文件名称
    private String targetFileName;
    // 模块名
    private String moduleName;
    // 项目目录
    private String targetProject;
    // 包名(包含模块名)
    private String targetPackage;
    // 模块包名
    private String modulePackage;
    // 静态资源根目录
    private String webappRootDir;
    // 静态资源业务模块根目录
    private String webappModuleRootDir;
    // 字段集合
    private List<FieldDefine> fieldList;

    public @Data class FieldDefine {
        private String javaProperty;
        private String fieldName;
        private String fieldComment;
        private boolean isPrimaryKey;
    }
}
