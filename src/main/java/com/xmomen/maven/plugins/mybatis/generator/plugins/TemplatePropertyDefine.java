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
    private String domainObjectClassName;
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
    // restful 资源映射名称
    private String restMapping;
    // 是否是静态资源模板
    private boolean isWebTemplate;
    // 静态资源web目录
    private String targetWebDir;
    // 静态资源模块目录
    private String targetWebModuleDir;
    // 静态资源目标目录（可选）
    private String targetWebJsDir;
    // 静态资源目标目录（可选）
    private String targetWebHtmlDir;
    // 字段集合
    private List<FieldDefine> fieldList;
    // 导入的class
    private Map<String, String> importClassList;

    public @Data class FieldDefine {
        private String javaProperty;
        private String javaType;
        private String fieldName;
        private String fieldComment;
        private boolean isPrimaryKey;
        private int maxLength;
        private boolean isNullable;
        private boolean isHide;

    }
}
