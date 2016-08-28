package com.xmomen.maven.plugins.mybatis.generator.plugins;

/**
 * Created by tanxinzheng on 16/8/28.
 */
public class TemplatePropertyDefine {

    /**
     * 项目目录
     */
    private String targetProject;
    /**
     * 包名
     */
    private String targetPackage;
    /**
     * 模块包名
     */
    private String modulePackage;
    /**
     * 表名
     */
    private String tableName;
    /**
     * 类名
     */
    private String className;
    /**
     * 业务领域对象名称
     */
    private String domainObjectName;
    /**
     * 模板文件
     */
    private String templateFileName;

    /**
     * 目标文件名称
     */
    private String targetFileName;

    public TemplatePropertyDefine(String targetFileName, String targetPackage, String templateFileName) {
        this.targetFileName = targetFileName;
        this.targetPackage = targetPackage;
        this.templateFileName = templateFileName;
    }

    public String getTargetProject() {
        return targetProject;
    }

    public void setTargetProject(String targetProject) {
        this.targetProject = targetProject;
    }

    public String getTargetPackage() {
        return targetPackage;
    }

    public void setTargetPackage(String targetPackage) {
        this.targetPackage = targetPackage;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getDomainObjectName() {
        return domainObjectName;
    }

    public void setDomainObjectName(String domainObjectName) {
        this.domainObjectName = domainObjectName;
    }

    public String getTemplateFileName() {
        return templateFileName;
    }

    public void setTemplateFileName(String templateFileName) {
        this.templateFileName = templateFileName;
    }

    public String getModulePackage() {
        return modulePackage;
    }

    public void setModulePackage(String modulePackage) {
        this.modulePackage = modulePackage;
    }

    public String getTargetFileName() {
        return targetFileName;
    }

    public void setTargetFileName(String targetFileName) {
        this.targetFileName = targetFileName;
    }
}
